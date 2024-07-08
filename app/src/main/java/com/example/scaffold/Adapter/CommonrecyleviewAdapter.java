package com.example.scaffold.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scaffold.R;
import com.example.scaffold.bean.CommonrecyleviewModel;

import java.util.ArrayList;


public class CommonrecyleviewAdapter extends RecyclerView.Adapter<CommonrecyleviewAdapter.MyHolder> {
    Context context;
    ArrayList<CommonrecyleviewModel>usersList;
    public CommonrecyleviewAdapter(Context context, ArrayList<CommonrecyleviewModel>usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public CommonrecyleviewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_commonrecyleview,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommonrecyleviewAdapter.MyHolder holder, int position) {
        holder.username.setText(usersList.get(position).getUser());

    }

    @Override
    public int getItemCount() {
        return this.usersList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView username;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
        }
    }
}
