package com.example.retrofitdemoa.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemoa.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RetrofitDemoAgainAdapter extends RecyclerView.Adapter <RetrofitDemoAgainAdapter.ViewHolder>{

    private ArrayList<Wallpepar_Model> wallpepar_modelArrayList;
    String TAG = "TAG";
    private Context context;
    public RetrofitDemoAgainAdapter(RetrofitDemoAgainContainer retrofitDemoAgainContainer, ArrayList<Wallpepar_Model> dataReArrayList)
    {
        this.wallpepar_modelArrayList =dataReArrayList;
        this.context =retrofitDemoAgainContainer;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View retrofitdemoagain = layoutInflater.inflate(R.layout.retrofitdemoagain_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(retrofitdemoagain);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {

        Picasso.get().load(wallpepar_modelArrayList.get(position).getCategoryImage()).into(holder.imgappicon);

        holder.lblappname.setText(wallpepar_modelArrayList.get(position).getCategories());

        holder.ryllayoutd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                //int cat_id = wallpepar_modelArrayList.get(position).getId();
                Intent intent = new Intent(context,ShowWallPepar_Activity.class);
                intent.putExtra("cat_id",wallpepar_modelArrayList.get(position).getId());
                context.startActivity(intent);

              // Toast.makeText(context, wallpepar_modelArrayList.get(position).getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return wallpepar_modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
     /*   TextView lblappname;
        ImageView imgappicon;
        RelativeLayout ryllayoutd;*/
     public ImageView imgappicon;
        public TextView lblappname;
        public RelativeLayout ryllayoutd;


        public ViewHolder(View itemView) {
            super(itemView);
            this.lblappname = (TextView) itemView.findViewById(R.id.lblappname);
            this.imgappicon = (ImageView) itemView.findViewById(R.id.imgappicon);
            ryllayoutd = itemView.findViewById(R.id.ryllayoutd);
        }
    }
}

