package com.wykmmam.rest_spring_java.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PingController {
    private final Logger logger =
            LoggerFactory.getLogger(PingController.class.getName());

    @GetMapping("/ping")
    public String testLog() {
        logger.info("Ping reached");
        return "pong";
    }
}
