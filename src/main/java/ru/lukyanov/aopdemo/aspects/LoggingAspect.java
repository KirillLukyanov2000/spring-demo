package ru.lukyanov.aopdemo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    //MINIMUM DETAILS POINTCUT
    @Before("execution(* *())")
    public void beforeGetBookAdvice(JoinPoint joinPoint) {
        log.warn("beforeGetBookAdvice: trying to take the Book from " + joinPoint.getTarget().getClass().getSimpleName());
    }

    //MAXIMUM DETAILS POINTCUT
    @AfterReturning("execution(public void ru.lukyanov.aopdemo.entity.Library.getBook() throws ru.lukyanov.aopdemo.exceptions.NoBookException)")
    public void afterGetBookAdvice(JoinPoint joinPoint) {
        log.warn("afterGetBookAdvice: the Book was taken after " + joinPoint.toShortString());
    }
}
