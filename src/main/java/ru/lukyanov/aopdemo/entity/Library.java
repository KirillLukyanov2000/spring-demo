package ru.lukyanov.aopdemo.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.lukyanov.aopdemo.exceptions.NoBookException;

@Slf4j
@Component("libraryBean")
public class Library extends AbstractLibrary{

    public void getBook() throws NoBookException {
        log.info("Taking the book from the Library");
    }
}
