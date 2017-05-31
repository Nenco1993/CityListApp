package com.example.neven.citylistapp.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.example.neven.citylistapp.R;
import com.example.neven.citylistapp.models.City;

import java.util.List;

/**
 * Created by Neven on 30.5.2017..
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private final List<City> listCity;
    private final Context context;
    private CityClickListener cityClickListener;

    public ListAdapter(List<City> listCity, Context context) {
        this.listCity = listCity;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        City singleCity = listCity.get(position);

        holder.tvCityName.setText(singleCity.getName());

        holder.itemView.setOnClickListener(view -> {
            if (cityClickListener != null) {
                cityClickListener.onCityClicked(singleCity);
            }
        });

        Glide
                .with(context)
                .load(listCity.get(position).getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.ivCityPicture);


    }

    @Override
    public int getItemCount() {
        return listCity.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivCityPicture)
        ImageView ivCityPicture;

        @BindView(R.id.ivArrow)
        ImageView ivArrow;

        @BindView(R.id.tvCityName)
        TextView tvCityName;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CityClickListener {

        void onCityClicked(City city);


    }

    public void setCityClickListener(CityClickListener cityClickListener) {
        this.cityClickListener = cityClickListener;
    }

}
