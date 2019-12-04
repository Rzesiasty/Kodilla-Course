package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Aspect
@Component
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processorOrder(..))" + "&& target(object) && args(order, userId)")
    public void logEvent(Object object, OrderDto order, Long userId) {
        LOGGER.info("Class: " + object.getClass().getName() + " items id: " + order.getItems().stream()
                .map(n -> n.getProductId().toString())
                .collect(Collectors.joining(" ,"))
                + " User id " + userId.toString());
        LOGGER.info("Method processorOrder is activated");
    }

    @AfterReturning("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processorOrder(..))")
    public void noErrorEvent() {
        LOGGER.info("The method call was successful");
    }

    @AfterThrowing(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processorOrder(..))", throwing = "ex")
    public void throwExceptionEvent(Exception ex) throws Throwable {
        LOGGER.info("Method throws: " + ex);
    }
}
