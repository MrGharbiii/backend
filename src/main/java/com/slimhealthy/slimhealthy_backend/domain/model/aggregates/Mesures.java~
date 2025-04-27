package com.slimhealthy.slimhealthy_backend.domain.model.aggregates;
import com.slimhealthy.slimhealthy_backend.domain.model.valueobjects.BasicInfo;
import lombok.Data;

@Data
public class Mesures {
    private BasicInfo basicInfo;

    public double calculateBMI() {
        return basicInfo.getCurrentWeight() /
                Math.pow(basicInfo.getHeight()/100, 2);
    }
}