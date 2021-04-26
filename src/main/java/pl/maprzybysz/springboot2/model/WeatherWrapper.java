package pl.maprzybysz.springboot2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class WeatherWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String observationTime;
    private int temperature;
    private int windSpeed;
    private int pressure;
    private int humidity;

    public WeatherWrapper() {
    }

    public WeatherWrapper(String city, String observationTime, int temperature, int windSpeed, int pressure,
                          int humidity) {
        this.city = city;
        this.observationTime = observationTime;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Long getId() {
        return id;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "WeatherWrapper{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", observationTime='" + observationTime + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}
