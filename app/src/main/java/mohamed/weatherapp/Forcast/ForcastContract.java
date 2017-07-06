package mohamed.weatherapp.Forcast;

import mohamed.weatherapp.Base.BaseContract;
import mohamed.weatherapp.model.WeatherForecast;

/**
 * Created by mohamed ibrahim on 7/6/2017.
 */

public interface ForcastContract {

    interface Presenter extends BaseContract.BasePresener {
        void getForcastForCity(String cityName);
    }


    interface View extends BaseContract.BaseView{
        void onSuccess(WeatherForecast weatherList);
    }
}
