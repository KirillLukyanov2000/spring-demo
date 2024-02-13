package ru.lukyanov.aopdemo.entity;

import ru.lukyanov.aopdemo.exceptions.NoBookException;

public abstract class AbstractLibrary {
    abstract void getBook() throws NoBookException;
}
