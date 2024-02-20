package ru.lukyanov.springdemo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("singleton")
public class PersonService {

    @PostConstruct
    public void init() {
        log.info("Bean PersonService initiated");
    }

    @PreDestroy
    public void destroy() {
        log.info("Bean PersonService destroyed");
    }
}
