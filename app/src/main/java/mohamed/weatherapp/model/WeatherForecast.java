package mohamed.weatherapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mohamed.ibrahim on 7/5/2017.
 */

public class WeatherForecast {
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cnt")
    @Expose
    private Long noOfForecastResult;
    @SerializedName("list")
    @Expose
    private List<Forecast> forecast = null;
    @SerializedName("cod")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     * @return City information
     * @see City
     */
    public City getCity() {
        return city;
    }

    public Long getNoOfForecastResult() {
        return noOfForecastResult;
    }

    /**
     * @return List of weather forecast for timed interval.
     * @see Forecast
     */
    public List<Forecast> getForecast() {
        return forecast;
    }

    public int getStatusCode() {
        return code;
    }

    public String statusMessage() {
        return message;
    }
}
