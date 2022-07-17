/** Este paquete contiene las clases que representan las entidades del dominio. */
package com.zinbig.mongodemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accidents")
public class Accident {

    @Id
    public String id;
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
    public String start_time;
    public String end_time;
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

}