package com.pityubak.founder.exception;

/**
 *
 * @author Pityubak
 */
public class ParameterRegistrationException extends RuntimeException {

    public ParameterRegistrationException(String message,Object... args) {
        super(String.format(message, args));
    }
    
    
}
