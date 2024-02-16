package ru.lukyanov.aopdemo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.lukyanov.aopdemo.entity.Library;

@Order(10)
@Slf4j
@Aspect
@Component
public class SecurityAspect {

    @Before("ru.lukyanov.aopdemo.aspects.pointcuts.LibraryPointcut.anyGetMethodPointcut()")
    public void beforeSecurityAdvice(JoinPoint joinPoint) {
        log.warn("beforeSecurityAdvice: checking authentication " + joinPoint.getKind());
    }

    @Around("ru.lukyanov.aopdemo.aspects.pointcuts.LibraryPointcut.errorPointcut()")
    public Library beforeErrorSecurityAdvice(ProceedingJoinPoint joinPoint) {
        Library library = (Library) joinPoint.getTarget();
        library.returnBook();
        log.error("Error log instead of returning the book from {}, number {}", library.getName(), library.getNumber());
        return library;
    }
    @AfterThrowing(pointcut = "ru.lukyanov.aopdemo.aspects.pointcuts.LibraryPointcut.DivByZeroPointcut()", throwing = "exc")
    public void afterThrowingExcDivByZeroPointcut(JoinPoint joinPoint, Throwable exc) {
        String excMessage = exc.getMessage();
        log.error("div by ZERO! ArithmeticException to follow with the message: {}", excMessage);
    }
}
