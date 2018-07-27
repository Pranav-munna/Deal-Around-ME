package com.xtron.dealaroundme.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.fragment.Drawer_fragment;

/**
 * Created by pranav on 31-01-2017.
 */

public class Drawer extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawes);

        getFragmentManager().beginTransaction()
                .add(R.id.drawer_page,new Drawer_fragment(),"Drawer_activity")
                .commit();
    }
}
