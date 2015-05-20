package org.fpt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAspectJAutoProxy
@ImportResource({ "classpath:aspect-config.xml" })
public class AspectConfig {
	
	public AspectConfig() {
		super();
	}
}