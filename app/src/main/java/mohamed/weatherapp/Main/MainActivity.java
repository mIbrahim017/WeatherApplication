package mohamed.weatherapp.Main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mohamed.weatherapp.Base.BaseActivity;
import mohamed.weatherapp.R;
import mohamed.weatherapp.Utils;
import mohamed.weatherapp.WeatherApplication;
import mohamed.weatherapp.model.CurrentWeather;

public class MainActivity extends BaseActivity implements MainContract.View {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    @BindView(R.id.editTexCityName)
    EditText editTexCityName;


    @BindView(R.id.citiesListRecyclerView)
    RecyclerView citiesListRecyclerView;

    private MainAdapter mainAdapter;
    private MainContract.Presneter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenter(this, WeatherApplication.getApIsServices());
        mainPresenter.getWeatherByName(null);

        mainAdapter = new MainAdapter(this, new ArrayList<CurrentWeather>()  , mainPresenter);

        citiesListRecyclerView.setHasFixedSize(true);
        citiesListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        citiesListRecyclerView.setAdapter(mainAdapter);


    }


    @OnClick(R.id.ButtonGetWeather)
    void onGetWeather() {
        final String city = editTexCityName.getText().toString();
        if (city.length() == 0) editTexCityName.setError("Please Enter city name");
        else {
            editTexCityName.setText("");
            mainPresenter.getWeatherByName(city);
        }


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Utils.detachHelpers(mainPresenter);
        super.onDestroy();
    }

    @Override
    public void onSuccess() {

        mainAdapter.addCurrentWeather(mainPresenter.getLIST_OF_CITIES());
    }
}
