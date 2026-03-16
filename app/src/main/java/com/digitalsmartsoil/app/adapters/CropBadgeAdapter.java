package com.digitalsmartsoil.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CropBadgeAdapter extends RecyclerView.Adapter<CropBadgeAdapter.CropBadgeViewHolder> {
    private List<String> cropList;

    public CropBadgeAdapter(List<String> cropList) {
        this.cropList = cropList;
    }

    @Override
    public CropBadgeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new CropBadgeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CropBadgeViewHolder holder, int position) {
        String crop = cropList.get(position);
        holder.cropNameView.setText(crop);
    }

    @Override
    public int getItemCount() {
        return cropList.size();
    }

    public void updateList(List<String> newList) {
        cropList = newList;
        notifyDataSetChanged();
    }

    public static class CropBadgeViewHolder extends RecyclerView.ViewHolder {
        public TextView cropNameView;

        public CropBadgeViewHolder(View itemView) {
            super(itemView);
            cropNameView = itemView.findViewById(android.R.id.text1);
        }
    }
}
