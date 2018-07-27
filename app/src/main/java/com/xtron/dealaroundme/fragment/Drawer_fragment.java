package com.xtron.dealaroundme.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.activity.Home;

/**
 * Created by pranav on 31-01-2017.
 */
public class Drawer_fragment extends Fragment implements View.OnClickListener {

    SharedPreferences sp;
    LinearLayout business_visiablity, user_visiablity, user_settings, business_settings, business_manage_deal, business_create_deal;
    String account_type;
    Button switch_user, user_settings_button, business_settings_button, manage_deal_button, create_deal_button, back, logout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawer_fragment, container, false);
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        sp = getActivity().getSharedPreferences("dealaroundme", Context.MODE_PRIVATE);
        business_visiablity = (LinearLayout) view.findViewById(R.id.business_visiablity);
        user_visiablity = (LinearLayout) view.findViewById(R.id.user_visiablity);

        user_settings_button = (Button) view.findViewById(R.id.user_settings_button);
        user_settings_button.setOnClickListener(this);
        business_settings_button = (Button) view.findViewById(R.id.business_settings_button);
        business_settings_button.setOnClickListener(this);
        manage_deal_button = (Button) view.findViewById(R.id.manage_deal_button);
        manage_deal_button.setOnClickListener(this);
        create_deal_button = (Button) view.findViewById(R.id.create_deal_button);
        create_deal_button.setOnClickListener(this);
        back = (Button) view.findViewById(R.id.back);
        back.setOnClickListener(this);
        logout = (Button) view.findViewById(R.id.logout);
        logout.setOnClickListener(this);

        user_settings = (LinearLayout) view.findViewById(R.id.user_settings);
        user_settings.setOnClickListener(this);
        business_settings = (LinearLayout) view.findViewById(R.id.business_settings);
        business_settings.setOnClickListener(this);
        business_manage_deal = (LinearLayout) view.findViewById(R.id.business_manage_deal);
        business_manage_deal.setOnClickListener(this);
        business_create_deal = (LinearLayout) view.findViewById(R.id.business_create_deal);
        business_create_deal.setOnClickListener(this);

        switch_user = (Button) view.findViewById(R.id.switch_user);
        switch_user.setOnClickListener(this);

        account_type = sp.getString("account_type", "error").toString();
        if (account_type.equals("user")) {
            business_visiablity.setVisibility(View.GONE);
            user_visiablity.setVisibility(View.VISIBLE);
        } else {
            business_visiablity.setVisibility(View.VISIBLE);
            user_visiablity.setVisibility(View.GONE);
        }

        switch_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account_type = sp.getString("account_type", "error").toString();
                SharedPreferences.Editor ed = sp.edit();
                if (account_type.equals("user")) {
                    ed.putString("account_type", "business");
                    ed.commit();
                    business_visiablity.setVisibility(View.VISIBLE);
                    user_visiablity.setVisibility(View.GONE);
                } else {
                    ed.putString("account_type", "user");
                    ed.commit();
                    business_visiablity.setVisibility(View.GONE);
                    user_visiablity.setVisibility(View.VISIBLE);
                }
            }
        });

        user_settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_settings.getVisibility() == View.VISIBLE) {
                    user_settings.setVisibility(View.GONE);
                    user_settings_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
                } else {
                    user_settings.setVisibility(View.VISIBLE);
                    user_settings_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0);
                }
            }
        });
        business_settings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (business_settings.getVisibility() == View.VISIBLE) {
                    business_settings.setVisibility(View.GONE);
                    business_settings_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
                } else {
                    business_settings.setVisibility(View.VISIBLE);
                    business_settings_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0);
                }
            }
        });

        manage_deal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (business_manage_deal.getVisibility() == View.VISIBLE) {
                    business_manage_deal.setVisibility(View.GONE);
                    manage_deal_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
                } else {
                    business_manage_deal.setVisibility(View.VISIBLE);
                    manage_deal_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0);
                }
            }
        });

        create_deal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (business_create_deal.getVisibility() == View.VISIBLE) {
                    business_create_deal.setVisibility(View.GONE);
                    create_deal_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_down, 0);
                } else {
                    business_create_deal.setVisibility(View.VISIBLE);
                    create_deal_button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.arrow_up, 0);
                }
            }
        });


        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getActivity().getWindow().setLayout((int) (width * .8), height);
        getActivity().getWindow().setGravity(Gravity.START);

        return view;
    }

    @Override
    public void onClick(View v) {
        Activity getactivity = getActivity();


        switch (v.getId()) {

            case R.id.back: {
                startActivity(new Intent(getactivity, Home.class));
                break;
            }
            case R.id.logout: {
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("userid", "");
                ed.commit();
                getactivity.finishAffinity();
                break;
            }
            /*case R.id.user_settings_button:{
                if (user_settings.getVisibility() == View.VISIBLE) {
                    user_settings.setVisibility(View.GONE);
                } else {
                    user_settings.setVisibility(View.VISIBLE);
                }

                break;
            }
            case R.id.business_settings_button:{
                if (business_settings.getVisibility() == View.VISIBLE) {
                    business_settings.setVisibility(View.GONE);
                } else {
                    business_settings.setVisibility(View.VISIBLE);
                }

                break;
            }
            case R.id.manage_deal_button:{
                if (business_manage_deal.getVisibility() == View.VISIBLE) {
                    business_manage_deal.setVisibility(View.GONE);
                } else {
                    business_manage_deal.setVisibility(View.VISIBLE);
                }

                break;
            }
            case R.id.create_deal_button:{
                if (business_create_deal.getVisibility() == View.VISIBLE) {
                    business_create_deal.setVisibility(View.GONE);
                } else {
                    business_create_deal.setVisibility(View.VISIBLE);
                }

                break;
            }*/

        }
    }
}