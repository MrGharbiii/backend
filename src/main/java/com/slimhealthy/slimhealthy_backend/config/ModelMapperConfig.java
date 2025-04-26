// config/ModelMapperConfig.java
package com.slimhealthy.slimhealthy_backend.config;

import com.slimhealthy.slimhealthy_backend.application.dto.MesuresDto;
import com.slimhealthy.slimhealthy_backend.domain.model.aggregates.Mesures;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        // Add explicit mapping configuration
        mapper.createTypeMap(MesuresDto.class, Mesures.class)
                .addMapping(MesuresDto::getAge, Mesures::setAge)
                .addMapping(MesuresDto::getHeight, Mesures::setHeight)
                .addMapping(MesuresDto::getCurrentWeight, Mesures::setCurrentWeight);

        return mapper;
    }
}