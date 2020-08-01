package com.pityubak.founder.service;

import com.pityubak.founder.data.Parameter;
import com.pityubak.founder.data.ParameterRegistration;
import com.pityubak.founder.data.Instance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pityubak
 */
public class NewInstanceServiceTest {

    private ParameterRegistration paramsReg;
    private InstanceService instanceService;

    public NewInstanceServiceTest() {
        paramsReg = new ParameterRegistration();
        Parameter param = new Parameter();
        String test = new String("test");
        param.registrateArgs(test);
        paramsReg.registerParameter(String.class, param);
        instanceService = new NewInstanceService(paramsReg);
    }

    @BeforeEach
    public void setUp() {
        paramsReg = new ParameterRegistration();
        Parameter param = new Parameter();
        String test = new String("test");
        param.registrateArgs(test);
        paramsReg.registerParameter(String.class, param);
        instanceService = new NewInstanceService(paramsReg);
    }

    /**
     * Test of createInstance method, of class NewInstanceService.
     */
    @Test
    public void testCreateInstance() {
        Instance target = new Instance.Builder(String.class)
                .build();
        String expected = new String("test");
        String result = instanceService.createInstance(target);
        assertTrue(expected.equals(result));

    }

}
