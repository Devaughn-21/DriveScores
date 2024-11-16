package com.example.drivescores.userinterface;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.drivescores.R;
import com.example.drivescores.data.DriverScore;
import com.example.drivescores.network.MockDriverScoreApi;
import com.example.drivescores.viewmodel.DriverScoreHistoryViewModel;
import com.example.drivescores.viewmodel.DriverScoreHistoryViewModelFactory;

import java.util.List;

public class DriverScoreActivity extends AppCompatActivity {
    private DriverScoreHistoryViewModel viewModel;
    private DriverScoreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_score); // Connect to the XML layout

        // Initialize the ViewModel with the mock API
        viewModel = new ViewModelProvider(this, new DriverScoreHistoryViewModelFactory(new MockDriverScoreApi()))
                .get(DriverScoreHistoryViewModel.class);

        // Initialize the ListView and Adapter
        ListView listView = findViewById(R.id.listViewDriverScores);
        adapter = new DriverScoreAdapter(this);
        listView.setAdapter(adapter);

        // Observe LiveData from the ViewModel
        viewModel.getScores().observe(this, this::updateScores);

        // Fetch mock data for the user
        viewModel.fetchDriverScores("mockUserId");
    }

    private void updateScores(List<DriverScore> scores) {
        adapter.setScores(scores); // Update the adapter with new data
    }
}
