package com.slimhealthy.slimhealthy_backend.application.dto;

import com.slimhealthy.slimhealthy_backend.domain.model.enums.*;
import jakarta.validation.constraints.*;
import lombok.Data;

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