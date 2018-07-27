package com.xtron.dealaroundme.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.activity.Login_register;

public class Login_page_fragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

//    RadioButton r_user,r_business;
    Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.login_page_fragment,container,false);

       /* r_user=(RadioButton) view.findViewById(R.id.user);
        r_user.setOnCheckedChangeListener(this);

        r_business=(RadioButton) view.findViewById(R.id.business);
        r_business.setOnCheckedChangeListener(this);*/

        login=(Button)view.findViewById(R.id.login);
        login.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Activity getactivity =getActivity();
        switch (view.getId()){
            case R.id.login:{
                startActivity(new Intent(getactivity, Login_register.class));
                break;
            }
        }


    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        /*if (!checked) return;
        r_business=(RadioButton) getActivity().findViewById(R.id.business);
        r_user=(RadioButton) getActivity().findViewById(R.id.user);
        switch (compoundButton.getId()){
            case R.id.user:{
                r_business.setBackgroundResource(R.drawable.right_round_primary_dark_transparent);
                r_user.setBackgroundResource(R.drawable.left_round_primary_dark);
                break;
            }case R.id.business:{
                r_business.setBackgroundResource(R.drawable.right_round_primary_dark);
                r_user.setBackgroundResource(R.drawable.left_round_primary_dark_transparent);
                break;
            }
        }*/

    }
}



