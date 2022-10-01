package com.partharoypc.retrofitapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.partharoypc.retrofitapp.R;
import com.partharoypc.retrofitapp.model.Model;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Model> postList;

    public CustomAdapter(List<Model> postList) {
        this.postList = postList;
    }


    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

        holder.pTitle.setText(postList.get(position).getTitle());
        holder.pBody.setText(postList.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView pTitle,pBody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pBody = itemView.findViewById(R.id.txtBody);
            pTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
