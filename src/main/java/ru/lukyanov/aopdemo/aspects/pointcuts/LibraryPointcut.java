package ru.lukyanov.aopdemo.aspects.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class LibraryPointcut {
    @Pointcut("execution(* get*())")
    public void anyGetMethodPointcut() {
    }

    @Pointcut("@annotation(ru.lukyanov.aopdemo.annotations.ErrorLog)")
    public void errorPointcut() {
    }

    @Pointcut("anyGetMethodPointcut() && errorPointcut()")
    public void allGetAndErrorPointcut() {
    }
}
