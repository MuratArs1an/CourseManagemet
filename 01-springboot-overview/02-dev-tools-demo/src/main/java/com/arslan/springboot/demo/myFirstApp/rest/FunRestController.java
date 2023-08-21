package com.arslan.springboot.demo.myFirstApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    //add a new end poiny

    @GetMapping("/workout")
    public String workOut(){
        return "Run a hard 5k!";
    }

    //expose a new end point for fortune
    @GetMapping("/fortune")
    public  String getDailyFortune(){
        return "Today is your lucky day ";
    }

    //inject properties coach.name and team.name
    @Value("${coach.name}")
    public String coach;

    @Value("${team.name}")
    public String team;

    @GetMapping("/teaminfo")
    public String teamInof(){
        return "coach : "+ coach+" team : "+team;
    }

}

