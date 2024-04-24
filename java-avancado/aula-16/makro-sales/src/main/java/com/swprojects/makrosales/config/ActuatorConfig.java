package com.swprojects.makrosales.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@Import({ SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@EnableAsync
public class ActuatorConfig {

}
