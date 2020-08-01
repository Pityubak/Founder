package com.pityubak.founder.service;

import com.pityubak.founder.data.Parameter;
import com.pityubak.founder.data.ParameterRegistration;
import com.pityubak.founder.data.Instance;
import com.pityubak.founder.exception.InstanceCreationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pityubak
 */
public class SingletonInstanceServiceTest {

    private final ParameterRegistration paramsReg;
    private final InstanceService instanceService;

    public SingletonInstanceServiceTest() {
        paramsReg = new ParameterRegistration();
        Parameter param = new Parameter();
        String test = new String("test");
        param.registrateArgs(test);
        paramsReg.registerParameter(String.class, param);
        InstanceService base = new NewInstanceService(paramsReg);
        instanceService = new SingletonInstanceService(base);
    }

    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of createInstance method, of class SingletonInstanceService.
     */
    @Test
    public void testCreateInstance() {
        Instance target = new Instance.Builder(String.class)
                .withName("first")
                .build();
        String expected = new String("test");
        String result = instanceService.createInstance(target);
        assertTrue(expected.equals(result));

    }

    @Test
    public void testReturnSingleton() {
        Instance target = new Instance.Builder(String.class)
                .withName("first")
                .build();

        String expected = instanceService.createInstance(target);
        String second = instanceService.createInstance(target);
        assertTrue(expected == second);
    }

    @Test
    public void testCreateInstanceTargetClassNull() {
        Instance target = new Instance.Builder(null)
                .build();
        Exception ex = assertThrows(InstanceCreationException.class,
                () -> instanceService.createInstance(target));
        String message = ex.getMessage();
        assertTrue(message.contains("Target class is null"));
    }

    @Test
    public void testCreateInstanceTargetNameNull() {
        Instance target = new Instance.Builder(String.class)
                .build();
        Exception ex = assertThrows(InstanceCreationException.class,
                () -> instanceService.createInstance(target));
        String message = ex.getMessage();
        assertTrue(message.contains("Name of target class is null"));
    }
}
