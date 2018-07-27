package com.xtron.dealaroundme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.fragment.Sign_up_fragment;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        getFragmentManager().beginTransaction()
                .add(R.id.sign_up_page,new Sign_up_fragment(),"Sign_up_activity")
                .commit();
    }
}
