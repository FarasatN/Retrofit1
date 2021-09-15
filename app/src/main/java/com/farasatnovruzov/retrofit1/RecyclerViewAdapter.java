package com.farasatnovruzov.retrofit1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farasatnovruzov.retrofit1.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    ArrayList<String> repos;
    private String[] colors = {"#c545ff","#ffee80","#008080","#e71e28","#ff6666","#4ca3dd","#bada55","#ccdfff","#D35400","#F5B041","#A9CCE3","#ABEBC6"};
    public RecyclerViewAdapter(ArrayList<String> repos) {
        this.repos = repos;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RecyclerViewHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RecyclerViewHolder holder, int position) {
//        holder.binding.recyclerViewTextView.setText(repos.get(position));
        holder.bind(repos.get(position),colors,position);
    }

    @Override
    public int getItemCount() {
//        return mainActivity.repos.size();
        return repos.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;
        public RecyclerViewHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String s, String[] colors, Integer position) {
            binding.recyclerViewTextView.setBackgroundColor(Color.parseColor(colors[position % 12]));
//            binding.recyclerViewTextView = itemView.findViewById(R.id.recyclerViewTextView);
            binding.recyclerViewTextView.setText(repos.get(position));

        }
    }


}
