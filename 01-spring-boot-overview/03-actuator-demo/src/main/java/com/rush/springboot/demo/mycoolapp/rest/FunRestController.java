package com.rush.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "Hello World"

    @GetMapping("/")
    public String sayHellow() {
        return "Hello World! Hehe";
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5K!";
    }

    // expose a new endpoint for "flower"

    @GetMapping("/flower")
    public String getFlower() {
        return "Here is the flower for you :D";
    }
}
