package com.helpflow.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.helpflow.core.service"})
public class BackendAppConfig {
}
