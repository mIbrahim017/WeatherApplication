package mohamed.weatherapp;

import android.app.Application;

import mohamed.weatherapp.network.APIsFactory;
import mohamed.weatherapp.network.APIsServices;

/**
 * Created by mohamed ibrahim on 7/5/2017.
 */

public class WeatherApplication extends Application {

    private static APIsServices apIsServices;

    public static APIsServices getApIsServices() {
        if (apIsServices == null) {
            apIsServices = APIsFactory.createInstance();
        }

        return apIsServices;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }

}
