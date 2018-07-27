package com.xtron.dealaroundme;

import com.xtron.dealaroundme.responce.CityListResponce;
import com.xtron.dealaroundme.responce.CountryListResponce;
import com.xtron.dealaroundme.responce.LoginResponce;
import com.xtron.dealaroundme.responce.LoginResponceBusiness;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by pranav on 23-02-2017.
 */

public interface Deal_around_me_interface {

    @FormUrlEncoded
    @POST("connection.php")
    Call<LoginResponce> login(@Field("user_mail") String email, @Field("pswd") String pass);

    @FormUrlEncoded
    @POST("connection_shop.php")
    Call<LoginResponceBusiness> loginbusiness(@Field("user_mail") String email, @Field("pswd") String pass);

    @GET("getCountryList.php")
    Call<CountryListResponce[]> getcountrylist();

    @FormUrlEncoded
    @POST("getCitiesList.php")
    Call<CityListResponce> citydetails(@Field("couId") String c_id);
}
