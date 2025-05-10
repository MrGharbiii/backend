package com.slimhealthy.slimhealthy_backend.domain.model.valueobjects;

import com.slimhealthy.slimhealthy_backend.domain.model.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BasicInfo {
    @Min(12) @Max(120)
    private int age;

    private Gender gender;

    @Positive
    private double height; // in cm

    @Positive
    private double currentWeight; // in kg

    @Positive
    private double targetWeight; // in kg
}