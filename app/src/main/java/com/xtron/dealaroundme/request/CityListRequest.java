package com.xtron.dealaroundme.request;

import android.content.Context;

import com.xtron.dealaroundme.AbstractRequest;
import com.xtron.dealaroundme.ProcessResponceInterface;
import com.xtron.dealaroundme.responce.CityListResponce;

import retrofit2.Call;

/**
 * Created by xtron on 28-02-2017.
 */

public class CityListRequest extends AbstractRequest<CityListResponce>{
    public CityListRequest(Context con, ProcessResponceInterface<CityListResponce> rhandler) {
        super(con, rhandler);
    }
    public void loginbusiness(String c_id) {
        Call<CityListResponce> call = deal_around_me_interface.citydetails(c_id);
        call.enqueue(this);
    }

}
