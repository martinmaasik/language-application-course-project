package net.javaguides.springboot.springsecurity.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @GetMapping ("/test")
    public String test() {
        return "What are you looking for? You have not written a test.";
    }
}
