package com.slimhealthy.slimhealthy_backend;

import com.slimhealthy.slimhealthy_backend.config.ModelMapperConfig;
import com.slimhealthy.slimhealthy_backend.security.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {
		"com.slimhealthy.slimhealthy_backend",
		"org.modelmapper"
})
@Import({ModelMapperConfig.class, SecurityConfig.class})
public class SlimHealthyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlimHealthyApplication.class, args);
	}

}
