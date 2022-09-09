package com.moon.demo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {


    @GetMapping("/hello3")
    public String handle()  {
        return "Hello WebFlux3";
    }

    @GetMapping("/hello24")
    public Mono<String> handle2() {
        return Mono.just("Hello WebFlux4");
    }

}