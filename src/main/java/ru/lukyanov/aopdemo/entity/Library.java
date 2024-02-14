package ru.lukyanov.aopdemo.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.lukyanov.aopdemo.annotations.ErrorLog;
import ru.lukyanov.aopdemo.exceptions.NoBookException;

@Slf4j
@Component("libraryBean")
public class Library extends AbstractLibrary {

    private String name;

    @Value("10")
    private int number;

    public int getNumber() {
        return number;
    }

    public void getBook() throws NoBookException {
        log.info("Taking the book from the Library");
    }

    @ErrorLog
    public void returnBook() {
        this.setName("Library Puskin");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isFavoriteLibrary() {
        return false;
    }
}
