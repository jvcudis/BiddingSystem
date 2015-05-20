package org.fpt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({ "org.fpt.aspect" })
public class AspectConfig {
	
	public AspectConfig() {
		super();
	}

}