package com.slimhealthy.slimhealthy_backend.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class SurgeryDto {
    private String name;


    private int year;
}
