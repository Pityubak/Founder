package com.pityubak.founder.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Pityubak
 */
public class ParameterRegistration {

    private final Map<Class<?>, Parameter> parameters = new HashMap<>();

    public void registerParameter(final Class<?> cls, final Parameter prm) {
        Objects.requireNonNull(cls, "Parameter's registration failed, class is null");
        Objects.requireNonNull(prm, "Parameter's registration failed, parameter is null");
        parameters.put(cls, prm);
    }

    public Parameter findParameterByClass(final Class<?> cls) {
        Objects.requireNonNull(cls, "Finding of parameter  failed, "
                + cls.getSimpleName() + " is null");
        return parameters.get(cls);
    }
}
