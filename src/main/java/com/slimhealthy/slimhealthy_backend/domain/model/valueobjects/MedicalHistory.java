package com.slimhealthy.slimhealthy_backend.domain.model.valueobjects;

import lombok.Data;

import java.util.List;

@Data
public class MedicalHistory {
    private List<String> allergies;
    private List<String> chronicConditions;
    private List<Surgery> surgeries;
    private List<String> medications;

}
