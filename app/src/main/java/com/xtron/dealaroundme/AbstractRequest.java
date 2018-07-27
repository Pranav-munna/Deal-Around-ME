package com.xtron.dealaroundme;

import android.content.Context;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by pranav on 23-02-2017.
 */

public abstract class AbstractRequest<T> implements Callback<T> {

    private static final String base_url = "http://beta.dealaround.me/webservices/";
    protected Context context;
    protected Deal_around_me_interface deal_around_me_interface;

    private ProcessResponceInterface<T> responcehandler;

    public AbstractRequest(Context con, ProcessResponceInterface<T> rhandler) {
        context = con;
        responcehandler = rhandler;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .client(new OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor)
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        deal_around_me_interface = retrofit.create(Deal_around_me_interface.class);
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.e("responce"," polichu monea");
        processResponse(response.body());
    }
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("response ", t.getMessage()+"  poe");
        processResponse(null);
    }

    private  void processResponse(T response){
        if(responcehandler != null){
            responcehandler.processResponce(response);
        }
    }
}
