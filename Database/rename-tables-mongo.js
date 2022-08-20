db.accidents.updateMany(
  {},
  {
    $rename: {
      "Temperature(F)": "Temperature",
      "Humidity(%)": "Humidity",
      "Pressure(in)": "Pressure",
      "Visibility(mi)": "Visibility",
      "Precipitation(in)": "Precipitation",
      distance: "Distance",
    },
  }
);

db.accident.updateMany(
  {},
  {
    $rename: {
      id: "id_accident",
    },
  }
);
/* 
Consulta Equivalente a:
select
 	weather_condition,
 	count(*) as total
from
 	accident a
group by
 	weather_condition
order by
 	total desc   */

db.accident.aggregate(
  [
    { $group: { _id: "$weather_condition", count: { $sum: 1 } } },
    { $sort: { count: -1 } },
  ],
  { allowDiskUse: true }
);

// add geoJSON field to accidents collection
db.runCommand({
  update: "accident",
  updates: [
    {
      q: {}, // query selector to match all documents in collection
      u: [
        // update of each matched document
        {
          $set: {
            geoloc: {
              type: "Point",
              coordinates: [
                { $toDecimal: "$start_lng" },
                { $toDecimal: "$start_lat" },
              ],
            },
          },
        },
      ],
      // Do no forget this line to be able to update multiple documents
      multi: true,
    },
  ],
});
db.accident.createIndex({ geoloc: "2dsphere" });

// query geopoint

db.accident.aggregate([
  {
    $geoNear: {
      near: { type: "Point", coordinates: [-84.058723, 39.865147] },
      distanceField: "dist.calculated",
      maxDistance: 1,
      includeLocs: "dist.accident_id",
      spherical: true,
    },
  },
  {
    $project: {
      _id: 0,
      id_accident: 1,
    },
  },
]);
