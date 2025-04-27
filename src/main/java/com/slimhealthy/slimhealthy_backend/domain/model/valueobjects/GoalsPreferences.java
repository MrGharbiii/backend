package com.slimhealthy.slimhealthy_backend.domain.model.valueobjects;

import com.slimhealthy.slimhealthy_backend.domain.model.enums.DietaryRestriction;
import com.slimhealthy.slimhealthy_backend.domain.model.enums.HealthGoal;
import com.slimhealthy.slimhealthy_backend.domain.model.enums.WorkoutPreference;
import lombok.Data;

import java.util.List;

@Data
public class GoalsPreferences {
    private HealthGoal primaryHealthGoal;
    private List<WorkoutPreference> workoutPreferences;
    private List<DietaryRestriction> dietaryRestrictions;
}
