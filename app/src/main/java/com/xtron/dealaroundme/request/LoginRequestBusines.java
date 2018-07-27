package com.xtron.dealaroundme.request;

import android.content.Context;

import com.xtron.dealaroundme.AbstractRequest;
import com.xtron.dealaroundme.ProcessResponceInterface;
import com.xtron.dealaroundme.responce.LoginResponceBusiness;

import retrofit2.Call;

/**
 * Created by pranav on 27-02-2017.
 */

public class LoginRequestBusines extends AbstractRequest<LoginResponceBusiness> {
    public LoginRequestBusines(Context con, ProcessResponceInterface<LoginResponceBusiness> rhandler) {
        super(con, rhandler);
    }

    public void loginbusiness(String email, String password) {
        Call<LoginResponceBusiness> call = deal_around_me_interface.loginbusiness(email, password);
        call.enqueue(this);
    }
}
