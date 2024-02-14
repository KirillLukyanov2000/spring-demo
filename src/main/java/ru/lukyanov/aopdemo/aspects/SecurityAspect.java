package ru.lukyanov.aopdemo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class SecurityAspect {

    @Before("ru.lukyanov.aopdemo.aspects.pointcuts.LibraryPointcut.anyGetMethodPointcut()")
    public void beforeSecurityAdvice(JoinPoint joinPoint) {
        log.warn("beforeSecurityAdvice: checking authentication " + joinPoint.getKind());
    }

    @Before("ru.lukyanov.aopdemo.aspects.pointcuts.LibraryPointcut.errorPointcut()")
    public void beforeErrorSecurityAdvice() {
        log.error("Error log before returning the book");
    }
}
