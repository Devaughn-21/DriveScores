package com.example.drivescores.network;

import com.example.drivescores.data.DriverScore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DriverScoreApi {
    /**
     * Fetches the list of driver scores for a specific user.
     *
     * @param userId The ID of the user whose scores are being fetched.
     * @return A Call object containing a list of DriverScore objects.
     */
    @GET("api/scores/{userId}")
    Call<List<DriverScore>> getDriverScores(@Path("userId") String userId);
}
