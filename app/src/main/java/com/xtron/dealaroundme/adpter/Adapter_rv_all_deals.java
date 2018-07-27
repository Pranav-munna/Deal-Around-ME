package com.xtron.dealaroundme.adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xtron.dealaroundme.R;
import com.xtron.dealaroundme.activity.Add_detail;

/**
 * Created by pranav on 31-01-2017.
 */

public class Adapter_rv_all_deals extends RecyclerView.Adapter<Adapter_rv_all_deals.Viewholder> {
    Context context;

    public Adapter_rv_all_deals(Context con){
        context=con;
    }


    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.rv_deal_list,parent,false);
        Viewholder viewholder= new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        ImageButton logo_image;
        TextView title,distance;
        public Viewholder(View itemView) {
            super(itemView);

            logo_image=(ImageButton)itemView.findViewById(R.id.logo_image);
            title=(TextView)itemView.findViewById(R.id.title);
            distance=(TextView)itemView.findViewById(R.id.distance);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.linear);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, Add_detail.class));
                }
            });

        }
    }
}
