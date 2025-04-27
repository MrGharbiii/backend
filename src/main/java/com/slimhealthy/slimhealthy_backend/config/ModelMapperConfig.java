package com.slimhealthy.slimhealthy_backend.config;

import com.slimhealthy.slimhealthy_backend.application.dto.MesuresDto;
import com.slimhealthy.slimhealthy_backend.application.dto.SurgeryDto;
import com.slimhealthy.slimhealthy_backend.domain.model.aggregates.Mesures;
import com.slimhealthy.slimhealthy_backend.domain.model.enums.*;
import com.slimhealthy.slimhealthy_backend.domain.model.valueobjects.Surgery;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);





        // Only map what's absolutely necessary
        mapper.typeMap(MesuresDto.class, Mesures.class)
                .addMappings(m -> {
                    // BasicInfo
                    m.<Integer>map(MesuresDto::getAge, (dest, v) -> dest.getBasicInfo().setAge(v));
                    m.<Gender>map(MesuresDto::getGender, (dest, v) -> dest.getBasicInfo().setGender(v));
                    m.<Double>map(MesuresDto::getHeight, (dest, v) -> dest.getBasicInfo().setHeight(v));
                    m.<Double>map(MesuresDto::getCurrentWeight, (dest, v) -> dest.getBasicInfo().setCurrentWeight(v));
                    m.<Double>map(MesuresDto::getTargetWeight, (dest, v) -> dest.getBasicInfo().setTargetWeight(v));
                    // LifestyleInfo
                    m.<Double>map(MesuresDto::getAvgSleepHours, (dest, v) -> dest.getLifeStyleInfo().setAvgSleepHours(v));
                    m.<ActivityLevel>map(MesuresDto::getActivityLevel, (dest, v) -> dest.getLifeStyleInfo().setActivityLevel(v));
                    m.<Boolean>map(MesuresDto::isSmoker, (dest, v) -> dest.getLifeStyleInfo().setSmoker(v));
                    m.<AlcoholConsumption>map(MesuresDto::getAlcoholConsumption, (dest, v) -> dest.getLifeStyleInfo().setAlcoholConsumption(v));
                    m.<List<String>>map(MesuresDto::getFoodPreferences, (dest, v) -> dest.getLifeStyleInfo().setFoodPreferences(v));

                    // GoalsPreferences
                    m.<HealthGoal>map(MesuresDto::getPrimaryHealthGoal, (dest, v) -> dest.getGoalsPreferences().setPrimaryHealthGoal(v));
                    m.<List<WorkoutPreference>>map(MesuresDto::getWorkoutPreferences, (dest, v) -> dest.getGoalsPreferences().setWorkoutPreferences(v));
                    m.<List<DietaryRestriction>>map(MesuresDto::getDietaryRestrictions, (dest, v) -> dest.getGoalsPreferences().setDietaryRestrictions(v));

                    // MedicalHistory
                    m.<List<String>>map(MesuresDto::getAllergies, (dest, v) -> dest.getMedicalHistory().setAllergies(v));
                    m.<List<String>>map(MesuresDto::getChronicConditions, (dest, v) -> dest.getMedicalHistory().setChronicConditions(v));
                    m.<List<String>>map(MesuresDto::getMedications, (dest, v) -> dest.getMedicalHistory().setMedications(v));
                    m.map(src -> {
                        if (src.getSurgeries() == null) {
                            return null;
                        }
                        List<Surgery> surgeries = new ArrayList<>();
                        for (SurgeryDto dto : src.getSurgeries()) {
                            Surgery surgery = new Surgery();
                            surgery.setName(dto.getName());
                            surgery.setYear(dto.getYear());
                            surgeries.add(surgery);
                        }
                        return surgeries;
                    }, (dest, v) -> dest.getMedicalHistory().setSurgeries((List<Surgery>) v));





                });

        return mapper;
    }
}