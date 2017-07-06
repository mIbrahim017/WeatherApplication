package mohamed.weatherapp;

import mohamed.weatherapp.Base.Detachable;

/**
 * Created by mohamed.ibrahim on 7/5/2017.
 */

public class Utils {


    /**
     * Util method for clean dependencies
     *
     * @param helpers
     */
    public static void detachHelpers(Detachable... helpers) {
        if (helpers == null) return;
        for (Detachable helper : helpers) {
            if (helper != null) helper.detach();
        }
    }


    public static String getDegree(double kelvin) {
        return String.format("%.1f",  kelvin - 273.15F) + "°";



    }

    public static int convertWeatherToColor(int ID) {
        int istat;
        switch (ID) {
            case 200:
            case 201:
            case 202:
            case 210:
            case 211:
            case 212:
            case 221:
            case 230:
            case 231:
            case 232:
                istat = R.color.rainyWeather;
                break;
            case 300:
            case 301:
            case 302:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case 321:
                istat = R.color.badWeather;
                break;
            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
            case 511:
            case 520:
            case 521:
            case 522:
            case 531:
                istat = R.color.rainyWeather;
                break;
            case 600:
            case 601:
            case 602:
            case 611:
            case 612:
            case 615:
            case 616:
            case 620:
            case 621:
            case 622:
                istat = R.color.badWeather;
                break;
            case 700:
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
            case 761:
            case 762:
            case 771:
            case 781:
                istat = R.color.warningWeather;
                break;
            case 800:
                istat = R.color.sunnyWeather;
                break;
            case 801:
                istat = R.color.sunnyWeather;
                break;
            case 802:
                istat = R.color.goodWeather;
                break;
            case 803:
            case 804:
                istat = R.color.goodWeather;
                break;
            case 900:
            case 901:
            case 902:
            case 903:
            case 904:
            case 905:
            case 906:
                istat = R.color.warningWeather;
                break;
            default:
                istat = R.color.sunnyWeather;
                break;
        }
        return istat;
    }

    public static int convertWeather(int ID) {
        switch (ID) {
            case 200:
            case 201:
            case 202:
            case 210:
            case 211:
            case 212:
            case 221:
            case 230:
            case 231:
            case 232:
                return R.drawable.ic_rain;

            case 300:
            case 301:
            case 302:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case 321:
                return R.drawable.ic_rain;

            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
            case 511:
            case 520:
            case 521:
            case 522:
            case 531:
                return R.drawable.ic_rain;

            case 600:
            case 601:
            case 602:
            case 611:
            case 612:
            case 615:
            case 616:
            case 620:
            case 621:
            case 622:
                return R.drawable.ic_rain;


            case 700:
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
            case 761:
            case 762:
            case 771:
            case 781:
                return R.drawable.ic_cloud;

            case 800:
                return R.drawable.ic_sunny;

            case 801:
            case 802:
                return R.drawable.ic_cloudy;
            case 803:
            case 804:
                return R.drawable.ic_cloud;
            case 900:
            case 901:
            case 902:
            case 903:
            case 904:
            case 905:
            case 906:
                return R.drawable.ic_cloud;
            default:
                return R.drawable.ic_sunny;

        }

    }


}
