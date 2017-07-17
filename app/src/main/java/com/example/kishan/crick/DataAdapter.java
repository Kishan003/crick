package com.example.kishan.crick;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.security.AccessController;
import java.util.ArrayList;

/**
 * Created by kishan on 12/07/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Matches> matches;
    private OnmatchClickListener onmatchClickListener;

    public DataAdapter(ArrayList<Matches> matches, OnmatchClickListener inMatchClickListener){
        this.matches= matches;
        this.onmatchClickListener = inMatchClickListener;

    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, final int i) {
        holder.matches_tv.setText(matches.get(i).getTeam1()+"V/S " + matches.get(i).getTeam2());
        holder.matches_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onmatchClickListener.onMatchClicked(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (matches== null){
            return 0;
        }
        return matches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView matches_tv;
        public ViewHolder(View view) {
            super(view);
            matches_tv = (TextView)view.findViewById(R.id.match_tv);
        }
    }
    public interface OnmatchClickListener{
        void onMatchClicked(int i);

    }
}
