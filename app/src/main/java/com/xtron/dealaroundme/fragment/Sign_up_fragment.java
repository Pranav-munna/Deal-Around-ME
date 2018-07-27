package com.xtron.dealaroundme.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.xtron.dealaroundme.ProcessResponceInterface;
import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.request.CountryListRequest;
import com.xtron.dealaroundme.responce.CountryListResponce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sign_up_fragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    LinearLayout linear_for_business;
    RadioButton r_user, r_business;
    SharedPreferences sp;
//    RecyclerView country, city, language;
//    Button
    Spinner country_b, city_b, language_b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment, container, false);

        Activity getactivity = getActivity();

        new CountryListRequest(getactivity, new ResponceProcessor()).getcountrylist();


//        RecyclerView r = (RecyclerView) view.findViewById(R.id.country);
//        country = (RecyclerView) view.findViewById(R.id.country);

        r_user = (RadioButton) view.findViewById(R.id.user);
        r_user.setOnCheckedChangeListener(this);
        r_user = (RadioButton) view.findViewById(R.id.user);
        r_user.setOnCheckedChangeListener(this);
        r_business = (RadioButton) view.findViewById(R.id.business);
        r_business.setOnCheckedChangeListener(this);

        country_b = (Spinner) view.findViewById(R.id.country_b);
//        country_b.setOnClickListener(this);

//        city_b = (Button) view.findViewById(R.id.city_b);
//        city_b.setOnClickListener(this);
//        language_b = (Button) view.findViewById(R.id.language_b);
//        language_b.setOnClickListener(this);

//        country = (RecyclerView) view.findViewById(R.id.country);
//        country.setOnClickListener(this);
//        city = (RecyclerView) view.findViewById(R.id.city);
//        city.setOnClickListener(this);
//        language = (RecyclerView) view.findViewById(R.id.language);
//        language.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            /*case R.id.country_b: {
                if (country.getVisibility() == View.GONE)
                    country.setVisibility(View.VISIBLE);
                else
                    country.setVisibility(View.GONE);
                break;
            }
            case R.id.city_b: {
                if (city.getVisibility() == View.GONE)
                    city.setVisibility(View.VISIBLE);
                else
                    city.setVisibility(View.GONE);
                break;
            }
            case R.id.language_b: {
                if (language.getVisibility() == View.GONE)
                    language.setVisibility(View.VISIBLE);
                else
                    language.setVisibility(View.GONE);
                break;
            }*/
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (!checked) return;
        Activity getactivity = getActivity();
        sp = getactivity.getSharedPreferences("dealaroundme", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        r_business = (RadioButton) getactivity.findViewById(R.id.business);
        linear_for_business = (LinearLayout) getactivity.findViewById(R.id.linear_for_business);
        r_user = (RadioButton) getactivity.findViewById(R.id.user);
        switch (compoundButton.getId()) {
            case R.id.user: {
                r_business.setBackgroundResource(R.drawable.right_round_primary_dark_transparent);
                r_user.setBackgroundResource(R.drawable.left_round_primary_dark);
                linear_for_business.setVisibility(View.GONE);
                ed.putString("account_type", "user");
                ed.commit();
                break;
            }
            case R.id.business: {
                r_business.setBackgroundResource(R.drawable.right_round_primary_dark);
                r_user.setBackgroundResource(R.drawable.left_round_primary_dark_transparent);
                linear_for_business.setVisibility(View.VISIBLE);
                ed.putString("account_type", "business");
                ed.commit();
                break;
            }
        }

    }

    private class ResponceProcessor implements ProcessResponceInterface<CountryListResponce[]> {

        @Override
        public void processResponce(CountryListResponce[] responce) {
            if (responce == null) {
                Log.e("categoiriessss", "categories is null, returning");
                return;
            }

            ArrayList<CountryListResponce> list = new ArrayList<>(Arrays.asList(responce));
            if (list == null || list.size() <= 0) {
                Log.e("response", list == null ? "categories is null" : "categories count is 0");
                return;
            }
            Activity getactivity =getActivity();
            if (getactivity==null)return;

            List<String> country_ = new ArrayList<String>();
            List<String> c_id =new ArrayList<String>();

            for(int i=0;i<=list.size();i++){
                if(i==0)
                {
                    country_.add(i,"--select Country--");
                    continue;
                }
                country_.add(i,list.get(i-1).getCouName());
                c_id.add(i-1,list.get(i-1).getCouId());
            }

            ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(getactivity,R.layout.view_spinner,country_);
            countryAdapter.setDropDownViewResource(R.layout.view_spinner);
            country_b.setAdapter(countryAdapter);



//            SharedPreferences sp=getactivity.getSharedPreferences("dealaroundme",Context.MODE_PRIVATE);
//            country_b.setText(sp.getString("country_name",""));
//            country.setVisibility(View.GONE);

        }
    }

}
