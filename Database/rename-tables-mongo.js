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
