package ru.lukyanov.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.lukyanov.springdemo")
@PropertySource("classpath:person.properties")
public class AppConfig {
}
