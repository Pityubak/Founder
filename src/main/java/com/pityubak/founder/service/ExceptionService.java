package com.pityubak.founder.service;

import com.pityubak.founder.data.Parameter;
import com.pityubak.founder.exception.InstanceCreationException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author Pityubak
 */
public class ExceptionService {

    private final Map<Object, Consumer> consumers = new HashMap<>();
 

    private ExceptionService() {
    }

    public static ExceptionService create() {
        return new ExceptionService();
    }

    public ExceptionService checkNameIsNotNull(String name) {
        registrateException(name, "Failed to create new instance."
                + " Name of target class is null");
        return this;
    }

    public ExceptionService checkClassIsNotNull(Class<?> checkedClass) {
        registrateException(checkedClass, "Failed to create new instance."
                + " Target class is null");
        return this;
    }
    
    public ExceptionService checkParameterIsNotNull(Parameter param) {
        registrateException(param, "Failed to registrate new parameter."
                + " Parameter is null");
        return this;
    }

    private void registrateException(Object tested, String msg) {
        Consumer consumer = t -> {
            if (t == null) {
                throw new InstanceCreationException(msg);
            }
        };
        consumers.put(tested, consumer);
    }

    public void throwOccuredException() {
        consumers.keySet().forEach(t -> {
            Consumer c = consumers.get(t);
            c.accept(t);
        });
    }
}
