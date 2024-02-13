package ru.lukyanov.aopdemo.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.lukyanov.aopdemo.exceptions.NoBookException;


@Slf4j
@Component("childrenLibraryBean")
public class ChildrenLibrary extends Library {
    @Override
    public void getBook()  {
        log.info("Taking the book from the Children Library");
    }
}
