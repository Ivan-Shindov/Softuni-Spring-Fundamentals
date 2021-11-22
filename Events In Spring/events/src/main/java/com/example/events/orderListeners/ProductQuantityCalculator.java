package com.example.events.orderListeners;

import com.example.events.MyCustomEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductQuantityCalculator {
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductQuantityCalculator.class);

    @EventListener(MyCustomEvent.class)
    public void onSomeEvent(MyCustomEvent myCustomEvent) {
        LOGGER.info("Order number {}, I am going to calculate current quantity", myCustomEvent.getOrderId());
    }
}
