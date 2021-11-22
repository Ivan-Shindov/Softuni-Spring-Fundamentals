package com.example.events;

import org.springframework.context.ApplicationEvent;

public class MyCustomEvent extends ApplicationEvent {

    private String orderId;

    public MyCustomEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }


    public String getOrderId() {
        return orderId;
    }

    public MyCustomEvent setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }
}
