package com.xtron.dealaroundme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.fragment.Forgot_password_fragment;


public class Forgot_password extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        getFragmentManager().beginTransaction()
                .add(R.id.forgot_password,new Forgot_password_fragment(),"Forgot_password_activity")
                .commit();
    }
}
