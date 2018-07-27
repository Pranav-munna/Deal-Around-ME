package com.xtron.dealaroundme.request;

import android.content.Context;

import com.xtron.dealaroundme.AbstractRequest;
import com.xtron.dealaroundme.ProcessResponceInterface;
import com.xtron.dealaroundme.responce.CountryListResponce;

import retrofit2.Call;

/**
 * Created by pranav on 28-02-2017.
 */

public class CountryListRequest extends AbstractRequest<CountryListResponce[]> {

    public CountryListRequest(Context con, ProcessResponceInterface<CountryListResponce[]> rhandler) {
        super(con, rhandler);
    }

    public void getcountrylist() {
        Call<CountryListResponce[]> call = deal_around_me_interface.getcountrylist();
        call.enqueue(this);
    }
}
