package ru.lukyanov.aopdemo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lukyanov.aopdemo.config.MyConfig;
import ru.lukyanov.aopdemo.entity.ChildrenLibrary;
import ru.lukyanov.aopdemo.entity.Library;

@Slf4j
public class Runner {

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Library library = context.getBean("libraryBean", Library.class);
        library.getBook();
        ChildrenLibrary childrenLibrary = context.getBean("childrenLibraryBean", ChildrenLibrary.class);
        childrenLibrary.getBook();
        childrenLibrary.returnBook("Tom Sayer");
        library.returnBook();
        library.isFavoriteLibrary();
        try {
            childrenLibrary.throwingTestException();
        } catch (ArithmeticException e) {
            log.error("ArithmeticException caught in main method.");
        }

        context.registerShutdownHook();
    }
}
