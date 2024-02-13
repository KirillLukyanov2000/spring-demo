package ru.lukyanov.aopdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.lukyanov.aopdemo")
@EnableAspectJAutoProxy
public class MyConfig {
}
