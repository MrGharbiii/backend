package com.slimhealthy.slimhealthy_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // Add test profile
class SlimHealthyApplicationTests {

	@Test
	void contextLoads() {
		// Test will pass if context loads
	}
}