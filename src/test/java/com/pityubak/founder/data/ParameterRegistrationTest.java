package com.pityubak.founder.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pityubak
 */
public class ParameterRegistrationTest {

    private final ParameterRegistration paramReg;
    private final Parameter param;

    public ParameterRegistrationTest() {
        paramReg = new ParameterRegistration();
        param = new Parameter();
    }

    /**
     * Test of registerParameter method, of class ParameterRegistration.
     */
    @Test
    public void testRegisterParameter() {
        Class cls = ParameterRegistrationTest.class;
        paramReg.registerParameter(cls, param);
        Parameter expectedParam = paramReg.findParameterByClass(cls);
        assertEquals(expectedParam, param);
    }

    @Test
    public void testRegisterParameterWithNullClass() {
        Class cls = null;
        Exception ex = assertThrows(NullPointerException.class,
                () -> paramReg.registerParameter(cls, param));
        String message = ex.getMessage();
        assertTrue(message.contains("class is null"));
    }

    @Test
    public void testRegisterParameterWithNullParameter() {
        Class cls = ParameterRegistrationTest.class;
        Parameter prm = null;
        Exception ex = assertThrows(NullPointerException.class,
                () -> paramReg.registerParameter(cls, prm));
        String message = ex.getMessage();
        assertTrue(message.contains("parameter is null"));
    }

    /**
     * Test of findParameterByClass method, of class ParameterRegistration.
     */
    @Test
    public void testFindParameterByClass() {
        Class cls = ParameterRegistrationTest.class;
        Parameter expectedParam = paramReg.findParameterByClass(cls);
        assertEquals(expectedParam, param);
    }

}
