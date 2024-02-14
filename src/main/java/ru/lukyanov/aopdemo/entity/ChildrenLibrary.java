package ru.lukyanov.aopdemo.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component("childrenLibraryBean")
public class ChildrenLibrary extends AbstractLibrary {
    private String name;

    public ChildrenLibrary(@Value("Tom Sayer") String name) {
        this.name = name;
    }

    @Override
    public void getBook() {
        log.info("Taking the book from the Children Library");
    }

    public void returnBook(String name) {
        log.info("Returning book " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
