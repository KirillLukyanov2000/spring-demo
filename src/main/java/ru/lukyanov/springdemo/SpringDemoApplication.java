package ru.lukyanov.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lukyanov.springdemo.config.AppConfig;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SpringApplication.run(SpringDemoApplication.class, args);
        applicationContext.registerShutdownHook();
    }

}
