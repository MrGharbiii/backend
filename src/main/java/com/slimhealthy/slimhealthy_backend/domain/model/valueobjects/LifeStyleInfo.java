package com.slimhealthy.slimhealthy_backend.domain.model.valueobjects;

import com.slimhealthy.slimhealthy_backend.domain.model.enums.*;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class LifeStyleInfo {

    @Positive
    private double avgSleepHours;

    private ActivityLevel activityLevel;
    private boolean isSmoker;
    private AlcoholConsumption alcoholConsumption;
    private List<String> foodPreferences;

    private NatureOfWork natureOfWork;
    private LocalTime usualWakeUpTime;
    private LocalTime usualSleepTime;
    private NapDuration napDuration;

    @Positive
    private double waterIntakeLiters;

    private StressLevel stressLevel;
    private WorkoutRoutine workoutRoutine;

    @Positive
    private double workoutAverageHours;

    @Positive
    private double dailyTimeAvailabilityHours;
}
