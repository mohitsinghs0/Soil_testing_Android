package com.digitalsmartsoil.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalsmartsoil.app.models.Farm;

import java.util.List;

public class FarmAdapter extends RecyclerView.Adapter<FarmAdapter.FarmViewHolder> {
    private List<Farm> farmList;
    private OnFarmClickListener listener;

    public interface OnFarmClickListener {
        void onFarmClick(Farm farm);
        void onFarmDelete(Farm farm);
    }

    public FarmAdapter(List<Farm> farmList, OnFarmClickListener listener) {
        this.farmList = farmList;
        this.listener = listener;
    }

    @Override
    public FarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new FarmViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FarmViewHolder holder, int position) {
        Farm farm = farmList.get(position);
        holder.bind(farm, listener);
    }

    @Override
    public int getItemCount() {
        return farmList.size();
    }

    public void updateList(List<Farm> newList) {
        farmList = newList;
        notifyDataSetChanged();
    }

    public static class FarmViewHolder extends RecyclerView.ViewHolder {
        private TextView farmNameView;

        public FarmViewHolder(View itemView) {
            super(itemView);
            farmNameView = itemView.findViewById(android.R.id.text1);
        }

        public void bind(Farm farm, OnFarmClickListener listener) {
            farmNameView.setText(farm.getFarmName());
            itemView.setOnClickListener(v -> listener.onFarmClick(farm));
        }
    }
}
