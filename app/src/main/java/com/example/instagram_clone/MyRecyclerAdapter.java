package com.example.instagram_clone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
  ArrayList<DataHandler> data;

  public MyRecyclerAdapter(ArrayList<DataHandler> data){
      this.data=data;
  }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      DataHandler dataDistributor = data.get(position);
      holder.imageView.setImageResource(dataDistributor.getImageView());
      holder.textView.setText(dataDistributor.getNameOfUser());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
           textView=itemView.findViewById(R.id.name);
           imageView=itemView.findViewById(R.id.profile_image);
        }
    }
}
