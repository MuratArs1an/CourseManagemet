package com.arslan.springCoreDemo.config;

import com.arslan.springCoreDemo.common.Coach;
import com.arslan.springCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
