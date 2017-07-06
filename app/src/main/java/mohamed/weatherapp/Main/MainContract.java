package mohamed.weatherapp.Main;

import java.util.List;

import mohamed.weatherapp.Base.BaseContract;
import mohamed.weatherapp.Base.Detachable;
import mohamed.weatherapp.model.CurrentWeather;

/**
 * Created by mohamed.ibrahim on 7/5/2017.
 */

public interface MainContract {

    interface Presneter extends BaseContract.BasePresener {

        void getWeatherByName(String countryName);

        void getWearherByLocaion(double lat, double lng);

        void removeCurrentWeather(int position);

        List<CurrentWeather> getLIST_OF_CITIES();
    }


    interface View extends BaseContract.BaseView {
        void onSuccess();
    }


}
