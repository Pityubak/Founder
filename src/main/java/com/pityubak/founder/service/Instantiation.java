package com.pityubak.founder.service;

import com.pityubak.founder.data.Args;
import com.pityubak.founder.data.Parameter;
import com.pityubak.founder.data.ParameterRegistration;
import com.pityubak.founder.exception.InstanceCreationException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 *
 * @author Pityubak
 */
public final class Instantiation {

    private final Class<?> createdClass;

    private final ParameterRegistration paramsReg;

    public Instantiation(final Class<?> createdClass, final ParameterRegistration params) {
        this.createdClass = createdClass;
        this.paramsReg = params;
    }

    public <R> R build() {

        try {
            Parameter prm = paramsReg.findParameterByClass(createdClass);
            if (prm == null) {
                Constructor defaultConstructor = createdClass.getConstructor();
                return (R) defaultConstructor.newInstance();
            } else {

                final List<Args> args = prm.getArgList();
                final Class<?>[] paramType = new Class<?>[args.size()];
                final Object[] params = new Object[args.size()];
                for (int i = 0; i < params.length; i++) {
                    Args argument = args.get(i);
                    params[i] = argument.getParam();
                    paramType[i] = argument.getParamType();
                }
                final Constructor neededCons = createdClass.getConstructor(paramType);
                return (R) neededCons.newInstance(params);
            }

        } catch (NoSuchMethodException
                | SecurityException
                | InstantiationException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException ex) {
            throw new InstanceCreationException("Failed to make new instance"
                    + " from %s. Error : %s", createdClass.getSimpleName(), ex);
        }
    }

}
