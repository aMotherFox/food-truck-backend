package com.my.FoodTruckBackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/helloWorld")
    public HelloWorld helloWorld() {
        return new HelloWorld("our hello world model object");
    }
}
