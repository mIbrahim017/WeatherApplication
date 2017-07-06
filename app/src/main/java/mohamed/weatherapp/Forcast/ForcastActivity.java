package mohamed.weatherapp.Forcast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mohamed.weatherapp.Base.BaseActivity;
import mohamed.weatherapp.R;
import mohamed.weatherapp.Utils;
import mohamed.weatherapp.WeatherApplication;
import mohamed.weatherapp.model.WeatherForecast;

/**
 * Created by mohamed ibrahim on 7/6/2017.
 */

public class ForcastActivity extends BaseActivity implements ForcastContract.View {

    @BindView(R.id.forcastList)
    RecyclerView forcastList;
    ForcastAdapter forcastAdapter;
    private String cityName;
    private ForcastContract.Presenter presenter;

    public static void navigate(Context context, String cityName) {
        Intent intent = new Intent(context, ForcastActivity.class);
        intent.putExtra("cityName", cityName);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forcast);
        ButterKnife.bind(this);
        cityName = getIntent().getStringExtra("cityName");

        forcastAdapter = new ForcastAdapter();

        forcastList.setAdapter(forcastAdapter);
        forcastList.setHasFixedSize(true);
        forcastList.setLayoutManager(new LinearLayoutManager(this));
        presenter = new ForcastPresenter(this, WeatherApplication.getApIsServices());
        presenter.getForcastForCity(cityName);
    }

    @Override
    public void onSuccess(WeatherForecast weatherList) {
        forcastAdapter.addWeatherForcast(weatherList);
    }

    @Override
    protected void onDestroy() {
        Utils.detachHelpers(presenter);
        super.onDestroy();
    }
}
