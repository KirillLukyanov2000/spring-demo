package ru.lukyanov.aopdemo.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component("childrenLibraryBean")
public class ChildrenLibrary extends AbstractLibrary {

    private String bookName;

    public ChildrenLibrary(@Value("Tom Sayer") String bookName) {
        this.bookName = bookName;
    }

    @Override
    public void getBook() {
        log.info("Taking the book from the Children Library");
    }

    public void returnBook(String name) {
        log.info("Returning book " + name);
    }

    public void throwingTestException() throws ArithmeticException {

        int a = 1 / 0;

    }

    public void checkinTimeInMillis(int a, int b) {
        int c = 0;
        for (int i = 0; i < b; i++) {
            c *= a;
        }
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
