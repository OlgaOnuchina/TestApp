package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.domain.print.LastDowntimePrint;

import java.util.List;

public class DowntimeAdapter extends RecyclerView.Adapter<DowntimeAdapter.DowntimeViewHolder> {

    private List<LastDowntimePrint> data;

    public DowntimeAdapter(List<LastDowntimePrint> data) {
        this.data = data;
    }


    public class DowntimeViewHolder extends RecyclerView.ViewHolder {

        TextView description;
        TextView period;
        public DowntimeViewHolder (View view){
            super(view);
            description = view.findViewById(R.id.recInfoDowntime);
            period = view.findViewById(R.id.recPeriodDowntime);
        }
    }

    @NonNull
    @Override
    public DowntimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewTipe){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_design, parent, false);
        return new DowntimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DowntimeViewHolder holder, int position) {
        LastDowntimePrint lastDowntimePrint = data.get(position);
        holder.description.setText(lastDowntimePrint.getDescription());
        holder.period.setText(lastDowntimePrint.getPeriod());
    }

    @Override
    public int getItemCount(){
        return data.size();
    }

}
