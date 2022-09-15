/** Este paquete contiene las clases que representan las entidades del dominio. */
package com.zinbig.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Entity
@Document(indexName = "accidents")
public class Accident {

    @Id()
    // La anottation field es necesaria porque elastic exige tener un field llamado
    // id, si se saca no levanta el proyecto
    @Field(name = "id")
    public String id_accident;
    public Boolean stop;
    public Boolean traffic_calming;
    public Boolean traffic_signal;
    public Boolean turning_loop;
    public Boolean amenity;
    public Boolean bump;
    public Boolean crossing;
    public Boolean give_way;
    public Boolean junction;
    public Boolean no_exit;
    public Boolean railway;
    public Boolean roundabout;
    public Boolean station;
    public Float humidity;
    public Float wind_speed;
    public Float precipitation;
    public Float start_lng;
    public Float tmc;
    public Float start_lat;
    public Float distance;
    public Float visibility;
    public Float number;
    public Float temperature;
    public Float wind_chill;
    public Float pressure;
    public Integer severity;
    public String description;
    public String weather_timestamp;
    public String source;
    public Date start_time;
    public Date end_time;
    public String end_lat;
    public String end_lng;
    public String street;
    public String side;
    public String city;
    public String county;
    public String state;
    public String zipcode;
    public String country;
    public String timezone;
    public String airport_code;
    public String wind_direction;
    public String sunrise_sunset;
    public String civil_twilight;
    public String nautical_twilight;
    public String astronomical_twilight;
    public String weather_condition;

    public Accident() {
    }

    // CREATE getters and setters

    public String getId() {
        return id_accident;
    }

    public void setId(String id) {
        this.id_accident = id;
    }

    public Boolean getStop() {
        return stop;
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }

    public Boolean getTraffic_calming() {
        return traffic_calming;
    }

    public void setTraffic_calming(Boolean traffic_calming) {
        this.traffic_calming = traffic_calming;
    }

    public Boolean getTraffic_signal() {
        return traffic_signal;
    }

    public void setTraffic_signal(Boolean traffic_signal) {
        this.traffic_signal = traffic_signal;
    }

    public Boolean getTurning_loop() {
        return turning_loop;
    }

    public void setTurning_loop(Boolean turning_loop) {
        this.turning_loop = turning_loop;
    }

    public Boolean getAmenity() {
        return amenity;
    }

    public void setAmenity(Boolean amenity) {
        this.amenity = amenity;
    }

    public Boolean getBump() {
        return bump;
    }

    public void setBump(Boolean bump) {
        this.bump = bump;
    }

    public Boolean getCrossing() {
        return crossing;
    }

    public void setCrossing(Boolean crossing) {
        this.crossing = crossing;
    }

    public Boolean getGive_way() {
        return give_way;
    }

    public void setGive_way(Boolean give_way) {
        this.give_way = give_way;
    }

    public Boolean getJunction() {
        return junction;
    }

    public void setJunction(Boolean junction) {
        this.junction = junction;
    }

    public Boolean getNo_exit() {
        return no_exit;
    }

    public void setNo_exit(Boolean no_exit) {
        this.no_exit = no_exit;
    }

    public Boolean getRailway() {
        return railway;
    }

    public void setRailway(Boolean railway) {
        this.railway = railway;
    }

    public Boolean getRoundabout() {
        return roundabout;
    }

    public void setRoundabout(Boolean roundabout) {
        this.roundabout = roundabout;
    }

    public Boolean getStation() {
        return station;
    }

    public void setStation(Boolean station) {
        this.station = station;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Float wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Float getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Float precipitation) {
        this.precipitation = precipitation;
    }

    public Float getStart_lng() {
        return start_lng;
    }

    public void setStart_lng(Float start_lng) {
        this.start_lng = start_lng;
    }

    public Float getTmc() {
        return tmc;
    }

    public void setTmc(Float tmc) {
        this.tmc = tmc;
    }

    public Float getStart_lat() {
        return start_lat;
    }

    public void setStart_lat(Float start_lat) {
        this.start_lat = start_lat;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getVisibility() {
        return visibility;
    }

    public void setVisibility(Float visibility) {
        this.visibility = visibility;
    }

    public Float getNumber() {
        return number;
    }

    public void setNumber(Float number) {
        this.number = number;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getWind_chill() {
        return wind_chill;
    }

    public void setWind_chill(Float wind_chill) {
        this.wind_chill = wind_chill;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeather_timestamp() {
        return weather_timestamp;
    }

    public void setWeather_timestamp(String weather_timestamp) {
        this.weather_timestamp = weather_timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getEnd_lng() {
        return end_lng;
    }

    public void setEnd_lng(String end_lng) {
        this.end_lng = end_lng;
    }

    public String getEnd_lat() {
        return end_lat;
    }

    public void setEnd_lat(String end_lat) {
        this.end_lat = end_lat;
    }

    public String street() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

}