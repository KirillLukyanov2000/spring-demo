package ru.lukyanov.aopdemo.aspects.pointcuts;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lukyanov.aopdemo.aspects.annotations.ErrorLog;

public class LibraryPointcut {
    @Pointcut("execution(* get*())")
    public void anyGetMethodPointcut() {
    }

    @Pointcut("@annotation(ru.lukyanov.aopdemo.aspects.annotations.ErrorLog)")
    public void errorPointcut() {
    }
}
