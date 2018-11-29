package com.loadaspasaspas.jinx.parser;

public class ArgumentParserException extends Exception {

    public ArgumentParserException(String message) {
        super(message);
    }

    public ArgumentParserException(Exception innerException) {
        super(innerException);
    }
}
