package com.xtron.dealaroundme.request;

import android.content.Context;

import com.xtron.dealaroundme.AbstractRequest;
import com.xtron.dealaroundme.ProcessResponceInterface;
import com.xtron.dealaroundme.responce.LoginResponce;

import retrofit2.Call;

/**
 * Created by xtron on 27-02-2017.
 */

public class LoginRequest extends AbstractRequest<LoginResponce> {
    public LoginRequest(Context con, ProcessResponceInterface<LoginResponce> rhandler) {
        super(con, rhandler);
    }

    public void login(String email, String password){
        Call<LoginResponce> call=deal_around_me_interface.login(email, password);
        call.enqueue(this);
    }

}
