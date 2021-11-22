package com.example.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class TestController {

    private ApplicationEventPublisher applicationEventPublisher;

    public TestController(ApplicationEventPublisher applicationEventPublisher) {

        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/create-event")
    public String test() {
        MyCustomEvent myCustomEvent = new MyCustomEvent(this, UUID.randomUUID().toString());
        applicationEventPublisher.publishEvent(myCustomEvent);

        return "index";
    }

}
