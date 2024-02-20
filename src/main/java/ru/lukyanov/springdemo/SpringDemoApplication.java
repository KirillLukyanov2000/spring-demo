package ru.lukyanov.springdemo;

import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lukyanov.hiberdemo.entity.Employee;
import ru.lukyanov.springdemo.config.AppConfig;
import ru.lukyanov.springdemo.entity.Person;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
        Person person = context.getBean("personBean", Person.class);

    }

}

