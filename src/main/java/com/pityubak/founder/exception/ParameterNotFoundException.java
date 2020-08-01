package com.pityubak.founder.exception;

/**
 *
 * @author Pityubak
 */
public class ParameterNotFoundException extends RuntimeException {

    public ParameterNotFoundException(String message, Object... args) {
        super(String.format(message, args));
    }

}
