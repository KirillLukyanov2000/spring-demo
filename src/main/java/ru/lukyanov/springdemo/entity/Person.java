package ru.lukyanov.springdemo.entity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component("personBean")
@Scope("prototype")
public class Person {

    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    @PostConstruct
    public void init() {
        log.info("Bean Person, name = {}, age = {} initiated", name, age);
    }

    @PreDestroy
    public void destroy() {
        log.info("Bean Person, name = {}, age = {} destroyed", name, age);
    }
}
