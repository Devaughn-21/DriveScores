package com.example.drivescores.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.drivescores.data.DriverScore;
import com.example.drivescores.network.DriverScoreApi;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Response;

public class DriverScoreHistoryViewModel extends ViewModel {
    private final DriverScoreApi api;
    private final MutableLiveData<List<DriverScore>> scores = new MutableLiveData<>();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public DriverScoreHistoryViewModel(DriverScoreApi api) {
        this.api = api;
    }

    /**
     * Returns a LiveData object containing the list of driver scores.
     */
    public LiveData<List<DriverScore>> getScores() {
        return scores;
    }

    /**
     * Fetches driver scores for a specific user.
     *
     * @param userId The ID of the user whose scores are being fetched.
     */
    public void fetchDriverScores(String userId) {
        executor.execute(() -> {
            try {
                Call<List<DriverScore>> call = api.getDriverScores(userId);
                Response<List<DriverScore>> response = call.execute();
                if (response.isSuccessful() && response.body() != null) {
                    scores.postValue(response.body());
                } else {
                    System.err.println("API Error: " + response.errorBody());
                }
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
            }
        });
    }
}
