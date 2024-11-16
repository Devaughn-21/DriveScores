package com.example.drivescores.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.drivescores.network.DriverScoreApi;

public class DriverScoreHistoryViewModelFactory implements ViewModelProvider.Factory {
    private final DriverScoreApi api;

    public DriverScoreHistoryViewModelFactory(DriverScoreApi api) {
        this.api = api;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DriverScoreHistoryViewModel.class)) {
            return (T) new DriverScoreHistoryViewModel(api);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
