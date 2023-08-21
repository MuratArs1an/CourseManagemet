package com.arslan.springCoreDemo.rest;

import com.arslan.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;
    // define a constructor for dependency injection
    @Autowired // tells spring to inject a dependency
    public DemoController(Coach coach){
        myCoach=coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
