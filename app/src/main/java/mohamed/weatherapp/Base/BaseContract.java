package mohamed.weatherapp.Base;

/**
 * Created by mohamed.ibrahim on 7/5/2017.
 */

public interface BaseContract {

    interface BasePresener extends  Detachable{

    }


      interface BaseView {

        boolean checkNetworkConnection();

        void showProgressBar();

        void hideProgressBar();

        void onFail(String message);

        void onFail(int resId);


    }

}
