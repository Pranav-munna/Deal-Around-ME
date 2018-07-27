package com.xtron.dealaroundme.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.xtron.dealaroundme.ProcessResponceInterface;
import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.activity.Forgot_password;
import com.xtron.dealaroundme.activity.Home;
import com.xtron.dealaroundme.activity.Sign_up;
import com.xtron.dealaroundme.request.LoginRequest;
import com.xtron.dealaroundme.request.LoginRequestBusines;
import com.xtron.dealaroundme.responce.LoginResponce;
import com.xtron.dealaroundme.responce.LoginResponceBusiness;

public class Login_register_fragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ProcessResponceInterface<LoginResponce> {

    RadioButton r_user, r_business;
    Button sign_up, forgot_pass, login_now_btn;
    EditText mail, password;
    String s_mail, s_password, user_id, account;
    SharedPreferences sp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_register_fragment, container, false);

        sp = getActivity().getSharedPreferences("dealaroundme", Context.MODE_PRIVATE);
        user_id = sp.getString("userid", "");

        if (!user_id.equals("")) {
            startActivity(new Intent(getActivity(), Home.class));
            getActivity().finish();
        }
        r_user = (RadioButton) view.findViewById(R.id.user);
        r_user.setOnCheckedChangeListener(this);

        r_business = (RadioButton) view.findViewById(R.id.business);
        r_business.setOnCheckedChangeListener(this);

        sign_up = (Button) view.findViewById(R.id.sign_up);
        sign_up.setOnClickListener(this);

        forgot_pass = (Button) view.findViewById(R.id.forgot_pass);
        forgot_pass.setOnClickListener(this);

        mail = (EditText) view.findViewById(R.id.mail);
        password = (EditText) view.findViewById(R.id.password);

        login_now_btn = (Button) view.findViewById(R.id.login_now_btn);
        login_now_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        Activity getactivity = getActivity();

        switch (view.getId()) {
            case R.id.sign_up: {
                startActivity(new Intent(getactivity, Sign_up.class));
                break;
            }
            case R.id.forgot_pass: {
                startActivity(new Intent(getactivity, Forgot_password.class));
                break;
            }
            case R.id.login_now_btn: {

                s_mail = mail.getText().toString();
                s_password = password.getText().toString();

                if (s_mail.trim().equals("") || s_password.trim().equals(""))
                    Toast.makeText(getactivity, "Enter Password & Email", Toast.LENGTH_SHORT).show();
                else {
                    sp = getActivity().getSharedPreferences("dealaroundme", Context.MODE_PRIVATE);
                    account = sp.getString("account_type", "");
                    if (account.equals("user"))
                        new LoginRequest(getactivity, this).login(s_mail, s_password);
                    else
                    if (account.equals("business"))
                        new LoginRequestBusines(getactivity,new x()).loginbusiness(s_mail, s_password);
                    else
                    Toast.makeText(getactivity, "select account type", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getactivity, Home.class));
                    break;
                }
                break;
            }
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (!checked) return;
        Activity getactivity = getActivity();

        SharedPreferences.Editor ed = sp.edit();

        r_business = (RadioButton) getactivity.findViewById(R.id.business);
        r_user = (RadioButton) getactivity.findViewById(R.id.user);
        switch (compoundButton.getId()) {
            case R.id.user: {
                r_business.setBackgroundResource(R.drawable.right_round_primary_dark_transparent);
                r_user.setBackgroundResource(R.drawable.left_round_primary_dark);
                ed.putString("account_type", "user");
                ed.commit();
                break;
            }
            case R.id.business: {
                r_business.setBackgroundResource(R.drawable.right_round_primary_dark);
                r_user.setBackgroundResource(R.drawable.left_round_primary_dark_transparent);
                ed.putString("account_type", "business");
                ed.commit();
                break;
            }
        }

    }

    @Override
    public void processResponce(LoginResponce responce) {
        if (responce.getAck().equals("success")) {
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("userid", responce.getId().toString());
            ed.commit();
            startActivity(new Intent(getActivity(), Home.class));
        } else
            Toast.makeText(getActivity(), responce.getAck() + "", Toast.LENGTH_SHORT).show();
    }

    class x implements ProcessResponceInterface<LoginResponceBusiness>{

        @Override
        public void processResponce(LoginResponceBusiness responce) {
            if (responce.getAck().equals("success")) {
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("userid", responce.getId().toString());
                ed.commit();
                startActivity(new Intent(getActivity(), Home.class));
            } else
                Toast.makeText(getActivity(), responce.getAck() + "", Toast.LENGTH_SHORT).show();
        }
    }
}

