package mohamed.weatherapp.Main;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import mohamed.weatherapp.model.CurrentWeather;
import mohamed.weatherapp.network.APIsServices;
import mohamed.weatherapp.network.NetworkUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.TextUtils.isEmpty;

/**
 * Created by mohamed.ibrahim on 7/5/2017.
 */

public class MainPresenter implements MainContract.Presneter {

    private static final String DEFAULT_COUNTRY = "London";

    private List<CurrentWeather> LIST_OF_CITIES = new ArrayList<>();
    private MainContract.View view;
    private APIsServices services;

    public MainPresenter(MainContract.View view, APIsServices services) {
        this.view = view;
        this.services = services;

    }

    public List<CurrentWeather> getLIST_OF_CITIES() {
        return LIST_OF_CITIES;
    }

    @Override
    public void detach() {
        view = null;
        services = null;
    }


    private void onWeatherSuccess(CurrentWeather currentWeather) {
        if (view == null) return;
        if (currentWeather == null) {
            NetworkUtils.checkNetworkError(new Exception("Error in network check again"), view);
            return;
        }


        LIST_OF_CITIES.add(currentWeather);
        view.hideProgressBar();
        view.onSuccess();

    }

    @Override
    public void getWeatherByName(final String countryName) {


        NetworkUtils.makeNetworkRequest(view, services.getCurrentWeatherByName(isEmpty(countryName) ? DEFAULT_COUNTRY : countryName, APIsServices.API_KEY), new Callback<CurrentWeather>() {
            @Override
            public void onResponse(@NonNull Call<CurrentWeather> call, @NonNull Response<CurrentWeather> response) {
                onWeatherSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeather> call, @NonNull Throwable t) {
                NetworkUtils.checkNetworkError(t, view);
            }
        });
    }

    @Override
    public void getWearherByLocaion(double lat, double lng) {
        NetworkUtils.makeNetworkRequest(view, services.getCurrentWeatherByLatLng(lat, lng, APIsServices.API_KEY), new Callback<CurrentWeather>() {
            @Override
            public void onResponse(@NonNull Call<CurrentWeather> call, @NonNull Response<CurrentWeather> response) {
                onWeatherSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<CurrentWeather> call, @NonNull Throwable t) {
                NetworkUtils.checkNetworkError(t, view);
            }
        });
    }

    @Override
    public void removeCurrentWeather(int position) {
        if (position >= 0 && position < LIST_OF_CITIES.size()) {
            LIST_OF_CITIES.remove(position);
            if (view != null)view.onSuccess();
        }
    }
}
