package com.example.drivescores.userinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.drivescores.R;
import com.example.drivescores.data.DriverScore;

import java.util.List;

public class DriverScoreAdapter extends ArrayAdapter<DriverScore> {
    private List<DriverScore> scores;

    public DriverScoreAdapter(Context context) {
        super(context, 0);
    }

    public void setScores(List<DriverScore> scores) {
        this.scores = scores;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return scores != null ? scores.size() : 0;
    }

    @Override
    public DriverScore getItem(int position) {
        return scores.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_driver_score, parent, false);
        }

        DriverScore score = getItem(position);

        TextView date = convertView.findViewById(R.id.tvScoreDate);
        TextView scoreValue = convertView.findViewById(R.id.tvScoreValue);
        TextView tripDetails = convertView.findViewById(R.id.tvTripDetails);

        date.setText("Date: " + score.getDate());
        scoreValue.setText("Score: " + score.getScore());
        tripDetails.setText("Trip: " + score.getTripDuration() + ", " + score.getDistance());

        return convertView;
    }
}
