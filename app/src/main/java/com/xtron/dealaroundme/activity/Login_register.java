package com.xtron.dealaroundme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.fragment.Login_register_fragment;

/**
 * Created by xtron on 28-01-2017.
 */

public class Login_register extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);

        getFragmentManager().beginTransaction()
                .add(R.id.login_register_page,new Login_register_fragment(),"login_register_activity")
                .commit();
    }


}
