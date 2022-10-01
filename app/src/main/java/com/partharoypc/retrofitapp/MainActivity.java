package com.partharoypc.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.partharoypc.retrofitapp.adapter.CustomAdapter;
import com.partharoypc.retrofitapp.model.Model;
import com.partharoypc.retrofitapp.nwtwork.RetrofitClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Model> postList;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        postList = new ArrayList<>();
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomAdapter(postList);
        recyclerView.setAdapter(adapter);
        getPosts();
    }

    private void getPosts() {
        RetrofitClass.getRetrofitClint().getPosts().enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful() && response.body() != null){
                    postList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something Is Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}