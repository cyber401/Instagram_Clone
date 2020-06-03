package com.example.instagram_clone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProfileScreen extends AppCompatActivity {
RecyclerView recyclerView;
MyRecyclerAdapter adapter;
ArrayList<DataDistributor> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        recyclerView=findViewById(R.id.recyclerView);
       data=new ArrayList<>();
       data.add(new DataDistributor(R.drawable.one,"Lalit Kumar"));
        data.add(new DataDistributor(R.drawable.two,"Virender Kumar"));
        data.add(new DataDistributor(R.drawable.three,"Tara Devi"));
        data.add(new DataDistributor(R.drawable.four,"Thakur Parshad"));
        data.add(new DataDistributor(R.drawable.five,"Chaten"));
        data.add(new DataDistributor(R.drawable.six,"Gautam Rai"));
        data.add(new DataDistributor(R.drawable.seven,"Manish Kumar"));
        data.add(new DataDistributor(R.drawable.eight,"Devesh Baniya"));
        adapter = new MyRecyclerAdapter(data);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }
}
