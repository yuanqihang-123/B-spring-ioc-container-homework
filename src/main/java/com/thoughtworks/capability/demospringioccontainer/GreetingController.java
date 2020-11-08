package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
public class GreetingController {

    @Autowired
    private WebApplicationContext context;

    @GetMapping("/greet")
    public String greet() {
        GreetingService greetingService = getGreetingService();
        return greetingService.sayHi() + " " + greetingService.toString();
    }

    private GreetingService getGreetingService() {
        return (GreetingService) context.getBean("greetingService");
    }

}
