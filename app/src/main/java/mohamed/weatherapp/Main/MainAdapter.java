package mohamed.weatherapp.Main;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mohamed.weatherapp.Forcast.ForcastActivity;
import mohamed.weatherapp.R;
import mohamed.weatherapp.Utils;
import mohamed.weatherapp.model.CurrentWeather;
import mohamed.weatherapp.model.Weather;

/**
 * Created by mohamed ibrahim on 7/5/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.VH> {

    private List<CurrentWeather> currentWeathers;
    private Context context;
    private LayoutInflater layoutInflater;
    private MainContract.Presneter presneter;

    public MainAdapter(Context context, List<CurrentWeather> currentWeathers, MainContract.Presneter presneter) {
        this.context = context;
        this.presneter = presneter;
        this.currentWeathers = currentWeathers;
        layoutInflater = LayoutInflater.from(context);
    }

    public void addCurrentWeather(List<CurrentWeather> currentWeather) {
        this.currentWeathers = currentWeather;
        notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(layoutInflater.inflate(R.layout.layout_weather_card, parent, false));
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {
        holder.deleteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presneter.removeCurrentWeather(holder.getAdapterPosition());

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForcastActivity.navigate(context, currentWeathers.get(holder.getAdapterPosition()).getCityName());
            }
        });
        holder.bindData(currentWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return currentWeathers == null ? 0 : currentWeathers.size();
    }


    static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.stattoday)
        ImageView stattoday;

        @BindView(R.id.city)
        TextView city;

        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.degree)
        TextView degree;

        @BindView(R.id.delete)
        ImageButton deleteImageButton;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void bindData(CurrentWeather currentWeather) {
            city.setText(currentWeather.getCityName());
            final Weather weather = currentWeather.getWeather().get(0);
            final int id = (int) weather.getId();
            stattoday.setImageResource(Utils.convertWeather(id));
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), Utils.convertWeatherToColor(id)));
            desc.setText(weather.getDescription());
            degree.setText(Utils.getDegree(currentWeather.getMain().getTemp()));
        }
    }
}
