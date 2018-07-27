package com.xtron.dealaroundme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.fragment.Add_detail_fragment;

/**
 * Created by pranav on 04-02-2017.
 */

public class Add_detail extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_detail);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.add_detail_page,new Add_detail_fragment(),"add_detail_activity")
                .commit();
    }
}
