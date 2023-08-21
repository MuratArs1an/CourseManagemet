package com.arslan.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class cricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling 15 min";
    }
}
