package org.fpt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Overall App Configuration
 *
 */
@Configuration
@ComponentScan({ "org.fpt" })
@Import({ WebConfig.class, PersistenceConfig.class, SecurityConfig.class })
public class AppConfig {
	
}
