package com.pityubak.founder.service;

import com.pityubak.founder.data.Args;
import com.pityubak.founder.data.Parameter;
import com.pityubak.founder.data.ParameterRegistration;
import com.pityubak.founder.exception.InstanceCreationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pityubak
 */
public class InstanceTest {

    public InstanceTest() {
    }

    /**
     * Test of build method, of class Instantiation.
     */
    @Test
    public void testBuildWithInstanceCreationException() {
        Class<?> createdClass = Args.class;
        ParameterRegistration paramsReg = new ParameterRegistration();
        Instantiation instance = new Instantiation(createdClass, paramsReg);
        Exception ex = assertThrows(InstanceCreationException.class,
                () -> instance.build());
        String msg = ex.getMessage();
        assertTrue(msg.contains("Failed to make new instance"));

    }

    @Test
    public void testBuildWithDefaultConstructor() {
        Class<?> createdClass = String.class;
        ParameterRegistration paramsReg = new ParameterRegistration();
        Instantiation instance = new Instantiation(createdClass, paramsReg);
        String value = new String();
        String expected = instance.build();
        assertTrue(expected.equals(value));

    }

    @Test
    public void testBuildWithParameterizedConstructor() {
        Class<?> createdClass = String.class;
        ParameterRegistration paramsReg = new ParameterRegistration();
        Parameter argParameter = new Parameter();
        String name = "test";
        argParameter.registrateArgs(name);
        paramsReg.registerParameter(createdClass, argParameter);
        Instantiation instance = new Instantiation(createdClass, paramsReg);
        String expected = instance.build();
        assertTrue(expected.equals(name));
    }

}
