package ru.lukyanov.aopdemo;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lukyanov.aopdemo.config.MyConfig;
import ru.lukyanov.aopdemo.entity.ChildrenLibrary;
import ru.lukyanov.aopdemo.entity.Library;

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

        context.registerShutdownHook();
    }
}
