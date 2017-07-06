package mohamed.weatherapp.Forcast;

import mohamed.weatherapp.model.WeatherForecast;
import mohamed.weatherapp.network.APIsServices;
import mohamed.weatherapp.network.NetworkUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohamed ibrahim on 7/6/2017.
 */

public class ForcastPresenter implements ForcastContract.Presenter {

    private ForcastContract.View view;
    private APIsServices apIsServices;

    public ForcastPresenter(ForcastContract.View view, APIsServices apIsServices) {
        this.view = view;
        this.apIsServices = apIsServices;
    }

    @Override
    public void getForcastForCity(String cityName) {
        NetworkUtils.makeNetworkRequest(view, apIsServices.getDailyForecast(cityName, "5", APIsServices.API_KEY), new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                onForcastSuccess(response.body());
            }

            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {
                NetworkUtils.checkNetworkError(t, view);
            }
        });
    }

    private void onForcastSuccess(WeatherForecast weatherForecast) {
        if (view == null) return;
        if (weatherForecast == null) {
            NetworkUtils.checkNetworkError(new Exception("Error in network check again"), view);
            return;
        }

        view.hideProgressBar();
        view.onSuccess(weatherForecast);
    }

    @Override
    public void detach() {
        this.view = null;
        this.apIsServices = null;
    }
}
