package mohamed.weatherapp.network;

import mohamed.weatherapp.model.CurrentWeather;
import mohamed.weatherapp.model.WeatherForecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mohamed.ibrahim on 7/5/2017.
 */

public interface APIsServices {

    public final static String API_KEY = "308aa2460641b18ea75bee872146a778";


    @GET("weather")
    Call<CurrentWeather> getCurrentWeatherByName(@Query("q") String cityAndCountry, @Query("appid") String apikey);

    @GET("weather")
    Call<CurrentWeather> getCurrentWeatherByLatLng(@Query("lat") double latitude, @Query("lon") double longitude, @Query("appid") String apikey);


    @GET("forecast/daily")
    Call<WeatherForecast> getDailyForecast(@Query("lat") double latitude,
                                           @Query("lon") double longitude,
                                           @Query("cnt") String limit,
                                           @Query("appid") String apikey);

    @GET("forecast/daily")
    Call<WeatherForecast> getDailyForecast(@Query("q") String cityAndCountry,
                                           @Query("cnt") String limit,
                                           @Query("appid") String apikey);

}
