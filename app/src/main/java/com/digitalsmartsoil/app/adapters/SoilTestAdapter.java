package com.digitalsmartsoil.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalsmartsoil.app.models.SoilTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SoilTestAdapter extends RecyclerView.Adapter<SoilTestAdapter.SoilTestViewHolder> {
    private List<SoilTest> soilTestList;
    private OnSoilTestClickListener listener;

    public interface OnSoilTestClickListener {
        void onTestClick(SoilTest test);
    }

    public SoilTestAdapter(List<SoilTest> soilTestList, OnSoilTestClickListener listener) {
        this.soilTestList = soilTestList;
        this.listener = listener;
    }

    @Override
    public SoilTestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new SoilTestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SoilTestViewHolder holder, int position) {
        SoilTest test = soilTestList.get(position);
        holder.bind(test, listener);
    }

    @Override
    public int getItemCount() {
        return soilTestList.size();
    }

    public void updateList(List<SoilTest> newList) {
        soilTestList = newList;
        notifyDataSetChanged();
    }

    public static class SoilTestViewHolder extends RecyclerView.ViewHolder {
        private TextView dateView;
        private TextView statusView;

        public SoilTestViewHolder(View itemView) {
            super(itemView);
            dateView = itemView.findViewById(android.R.id.text1);
            statusView = itemView.findViewById(android.R.id.text2);
        }

        public void bind(SoilTest test, OnSoilTestClickListener listener) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String dateStr = format.format(new Date(test.getTestDate()));
            dateView.setText("Test Date: " + dateStr);
            statusView.setText("Status: " + test.getStatus());
            itemView.setOnClickListener(v -> listener.onTestClick(test));
        }
    }
}
