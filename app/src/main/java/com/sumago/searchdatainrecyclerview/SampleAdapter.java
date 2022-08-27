package com.sumago.searchdatainrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {

    Context context;
    ArrayList<Model> List = new ArrayList<Model>();

    public SampleAdapter(Context context, ArrayList<Model> list) {
        this.context = context;
        List = list;
    }

    public void setFilteredList(ArrayList<Model> ListToShow){
        this.List= ListToShow;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.show_data_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(List.get(position).getName());
        holder.password.setText(List.get(position).getPassword());
        holder.address.setText(List.get(position).getAddress());
        holder.mobile.setText(List.get(position).getMobile());

    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, password, address, mobile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            password = itemView.findViewById(R.id.password);
            address = itemView.findViewById(R.id.address);
            mobile = itemView.findViewById(R.id.mobile);
        }
    }


}
