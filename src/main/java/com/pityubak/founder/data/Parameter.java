package com.pityubak.founder.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Pityubak
 */
public class Parameter {

    private final List<Args> args = new ArrayList<>();

    public <T> void registrateArgs(final T value) {
        Objects.requireNonNull(value, "Parameter is null");
        Class<?> paramType = value.getClass();
        this.args.add(new Args(paramType, value));
    }

    public <T> void registrateArgsWithParentInterface(final T value) {
        Objects.requireNonNull(value, "Parameter is null");
        Class<?> paramType = value.getClass();
        Class<?>[] parentInterfaces = paramType.getInterfaces();
        Class<?> parent = parentInterfaces[0];
        this.args.add(new Args(parent, value));
    }

    public List<Args> getArgList() {
        return Collections.unmodifiableList(args);
    }

}
