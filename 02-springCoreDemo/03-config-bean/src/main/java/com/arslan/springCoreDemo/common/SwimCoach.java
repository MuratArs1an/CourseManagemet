package com.arslan.springCoreDemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("ın constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as a warm up";
    }
}
