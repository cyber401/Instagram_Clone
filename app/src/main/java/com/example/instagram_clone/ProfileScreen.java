package com.example.instagram_clone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileScreen extends AppCompatActivity {
RecyclerView recyclerView;
MyRecyclerAdapter adapter;
ArrayList<DataHandler> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        recyclerView=findViewById(R.id.recyclerView);
       data=new ArrayList<>();
       data.add(new DataHandler(R.drawable.one,"Lalit Kumar"));
        data.add(new DataHandler(R.drawable.two,"Virender Kumar"));
        data.add(new DataHandler(R.drawable.three,"Tara Devi"));
        data.add(new DataHandler(R.drawable.four,"Thakur Parshad"));
        data.add(new DataHandler(R.drawable.five,"Chaten"));
        data.add(new DataHandler(R.drawable.six,"Gautam Rai"));
        data.add(new DataHandler(R.drawable.seven,"Manish Kumar"));
        data.add(new DataHandler(R.drawable.eight,"Devesh Baniya"));
        adapter = new MyRecyclerAdapter(data);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}
