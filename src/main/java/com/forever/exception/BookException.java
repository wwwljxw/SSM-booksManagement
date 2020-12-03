package com.forever.exception;

public class BookException extends LibraryException{
    public BookException() {
    }

    public BookException(String message) {
        super(message);
    }
}
