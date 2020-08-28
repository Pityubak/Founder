package com.pityubak.founder.exception;

/**
 *
 * @author Pityubak
 */
public class InstanceCreationException extends RuntimeException{

    public InstanceCreationException(String message,Object... args) {
        super(String.format(message, args));
    }
    
    
}
