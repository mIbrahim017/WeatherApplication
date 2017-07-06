package mohamed.weatherapp.Forcast;


import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import mohamed.weatherapp.R;
import mohamed.weatherapp.Utils;
import mohamed.weatherapp.model.Forecast;
import mohamed.weatherapp.model.Weather;
import mohamed.weatherapp.model.WeatherForecast;

/**
 * Created by mohamed ibrahim on 7/6/2017.
 */

public class ForcastAdapter extends RecyclerView.Adapter<ForcastAdapter.VH> {

    private WeatherForecast weatherList;

    public void addWeatherForcast(WeatherForecast weatherList) {
        this.weatherList = weatherList;
        notifyDataSetChanged();
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_forcas_card, parent, false));
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        final Forecast forecast = weatherList.getForecast().get(position);

        final Weather weather = forecast.weather.get(0);
        Date time = new Date(forecast.forecastTime *1000);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd.");
        holder.tvDayName.setText(sdf.format(time));
        holder.tvDescription.setText(weather.getDescription());
        final int id = (int) weather.getId();

        holder.ivWeatheric.setImageResource(Utils.convertWeather(id));
        holder.cvCard.setBackgroundColor(ContextCompat.getColor(holder.cvCard.getContext(), Utils.convertWeatherToColor(id)));

        holder.tvTemperature.setText(Utils.getDegree(forecast.temp.day));


    }

    @Override
    public int getItemCount() {
        return (weatherList !=  null &&   weatherList.getForecast() != null) ?  weatherList.getForecast().size():0;
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvDayName;
        TextView tvDescription;
        TextView tvTemperature;
        ImageView ivWeatheric;
        LinearLayout cvCard;

        VH(View itemView) {
            super(itemView);
            this.tvDayName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvDescription = (TextView) itemView.findViewById(R.id.tvHome);
            this.tvTemperature = (TextView) itemView.findViewById(R.id.genre);
            this.ivWeatheric = (ImageView) itemView.findViewById(R.id.Stat);
            this.cvCard = (LinearLayout) itemView.findViewById(R.id.daycard);
        }


    }
}
