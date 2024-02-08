package ru.lukyanov.springdemo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;
}
