package com.pityubak.founder.data;

/**
 *
 * @author Pityubak
 */
public class Args<T> {

    private final Class<T> paramType;

    private final T param;

    public Args(Class<T> paramType, T param) {
        this.paramType = paramType;
        this.param = param;
    }

    public Class<T> getParamType() {
        return paramType;
    }

    public T getParam() {
        return param;
    }

}
