package com.projects.travelapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.projects.travelapp.Domains.CategoryDomain;
import com.projects.travelapp.Domains.PopularDomain;
import com.projects.travelapp.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    ArrayList<PopularDomain> items;
    DecimalFormat formatter;

    public TestAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
        formatter = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getTitle());

//        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicPath(), "drawable",
//                holder.itemView.getContext().getPackageName());
//
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.picImage);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView titleText;
            ImageView picImage;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                titleText = itemView.findViewById(R.id.title_text);
                picImage = itemView.findViewById(R.id.category_image);
            }
        }

    @Override
    public int getItemCount() {
        return items.size();
    }
}