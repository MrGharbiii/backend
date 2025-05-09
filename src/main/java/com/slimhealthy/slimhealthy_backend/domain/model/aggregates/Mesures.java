package com.slimhealthy.slimhealthy_backend.domain.model.aggregates;
import com.slimhealthy.slimhealthy_backend.domain.model.valueobjects.BasicInfo;
import com.slimhealthy.slimhealthy_backend.domain.model.valueobjects.GoalsPreferences;
import com.slimhealthy.slimhealthy_backend.domain.model.valueobjects.LifeStyleInfo;
import com.slimhealthy.slimhealthy_backend.domain.model.valueobjects.MedicalHistory;
import lombok.Data;

@Data
public class Mesures {
    private BasicInfo basicInfo = new BasicInfo();
    private LifeStyleInfo lifeStyleInfo = new LifeStyleInfo();
    private GoalsPreferences goalsPreferences = new GoalsPreferences();
    private MedicalHistory medicalHistory = new MedicalHistory();

    public double calculateBMI() {
        return basicInfo.getCurrentWeight() / Math.pow(basicInfo.getHeight()/100, 2);
    }
}