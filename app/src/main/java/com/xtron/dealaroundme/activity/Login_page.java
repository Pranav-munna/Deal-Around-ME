package com.xtron.dealaroundme.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xtron.dealaroundme.fragment.Login_page_fragment;
import com.xtron.dealaroundme.R;

public class Login_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        getFragmentManager().beginTransaction()
                .add(R.id.login_page,new Login_page_fragment(),"login_page_activity")
                .commit();
    }
}
