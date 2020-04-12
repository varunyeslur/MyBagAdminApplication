package com.example.mybagadminapplication.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mybagadminapplication.Model.Category;
import com.example.mybagadminapplication.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {

    List<Category> temp_text;
    Context context;
    viewHolder holder;
   

    public CategoryAdapter() {
    }

    public CategoryAdapter(Context context, List<Category> temp_text) {
        this.context = context;
        this.temp_text = temp_text;
    }

    @Override
    public int getItemCount() {
        return temp_text.size();
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lt_category, parent, false);
        holder = new viewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
       Category category=temp_text.get(position);
        holder.iv_dp.setImageResource(category.getDp());
        holder.tvName.setText(category.getName());
        
    }

   

    class viewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView iv_dp;

        viewHolder(final View itemview) {
            super(itemview);

            tvName = (TextView) itemview.findViewById(R.id.tv_name);

            iv_dp = itemview.findViewById(R.id.iv_dp);
        }
    }

}
