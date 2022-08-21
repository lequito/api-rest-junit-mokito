package com.alex.restapijunit.services.exceptions;

public class DataIntegratyViolatioException extends RuntimeException{
    public DataIntegratyViolatioException(String message) {
        super(message);
    }
}
