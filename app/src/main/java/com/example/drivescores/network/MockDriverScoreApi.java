package com.example.drivescores.network;

import com.example.drivescores.data.DriverScore;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.mock.Calls;

public class MockDriverScoreApi implements DriverScoreApi {
    @Override
    public Call<List<DriverScore>> getDriverScores(String userId) {
        // Mock data for testing
        List<DriverScore> mockScores = Arrays.asList(
                new DriverScore("2024-11-11", 87, "30 mins", "15 miles"),
                new DriverScore("2024-11-10", 92, "25 mins", "12 miles"),
                new DriverScore("2024-11-09", 78, "40 mins", "20 miles")
        );

        // Simulate a successful API response
        return Calls.response(mockScores);
    }
}
