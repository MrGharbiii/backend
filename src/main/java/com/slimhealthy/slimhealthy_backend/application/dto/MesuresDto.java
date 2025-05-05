package com.slimhealthy.slimhealthy_backend.application.dto;

import com.slimhealthy.slimhealthy_backend.domain.model.enums.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class MesuresDto {
    @Min(12) @Max(120)
    private int age;

    private Gender gender;

    @Positive
    private double height;

    @Positive
    private double currentWeight;

    @Positive
    private double targetWeight;

    // LifestyleInfo fields
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

    // GoalsPreferences fields
    private HealthGoal primaryHealthGoal;

    private List<WorkoutPreference> workoutPreferences;

    private List<DietaryRestriction> dietaryRestrictions;

    // MedicalHistory fields
    private List<String> allergies;

    private List<String> chronicConditions;

    private List<SurgeryDto> surgeries;

    private List<String> medications;
}