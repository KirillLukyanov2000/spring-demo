package ru.lukyanov.aopdemo.aspects;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.lukyanov.aopdemo.entity.ChildrenLibrary;

@Order(20)
@Slf4j
@Aspect
@Component
public class LoggingAspect {

    //MINIMUM DETAILS POINTCUT
    @Before("execution(* *())")
    public void beforeAllMethodsAdvice(JoinPoint joinPoint) {
        log.warn("beforeAllMethodsAdvice: working in class: " + joinPoint.getTarget().getClass().getSimpleName());
    }

    //MAXIMUM DETAILS POINTCUT
    @AfterReturning("execution(public void ru.lukyanov.aopdemo.entity.Library.getBook() throws ru.lukyanov.aopdemo.exceptions.NoBookException)")
    public void afterGetBookAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        log.warn("afterGetBookAdvice: the Book was taken after execution of\n {}; in short: {}; method name: {}", signature.getMethod(), signature.toShortString(), signature.getName());
    }

    @SneakyThrows
    @Before("execution(* return*(String || int, ..))")
    public void beforeReturnWithNameAdvice(JoinPoint joinPoint) {
        ChildrenLibrary library = (ChildrenLibrary) joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();
        String argName = null;
        for (Object arg : args) {
            if (arg instanceof String) {
                argName = "String";
                break;
            }
        }
        log.warn("beforeGetBookWithNameAdvice: trying to return the Book with name {} from {}.\n Number of method parameters: {}, method parameter is: {}",
                library.getBookName(), joinPoint.getTarget().getClass().getSimpleName(), args.length, argName);
    }

    @AfterReturning(pointcut = "execution(* is*())", returning = "isFavLib")
    public void afterReturningCreateLibraryAdvice(JoinPoint joinPoint, Boolean isFavLib) {
        Boolean changeTheAnswer = !isFavLib;
        log.warn("Is this library your favorite after Advice interception? {}", changeTheAnswer);
    }
    @Around("ru.lukyanov.aopdemo.aspects.pointcuts.LibraryPointcut.checkingMethodWorkTimeAdvice()")
    public void checkTimeExecutionAdvice(ProceedingJoinPoint joinPoint) {
        long timeInMillis1 = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long timeInMillis2 = System.currentTimeMillis();
        log.info("Execution of the method took: {} ms", timeInMillis2 - timeInMillis1);
    }
}
