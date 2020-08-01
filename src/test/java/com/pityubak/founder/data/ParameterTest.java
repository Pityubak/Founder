package com.pityubak.founder.data;

import com.pityubak.founder.exception.ParameterRegistrationException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Pityubak
 */
public class ParameterTest {

    public ParameterTest() {
    }

    /**
     * Test of registrateArgs method, of class Parameter.
     */
    @Test
    public void testRegistrateArgs() {
        ForRegistration forReg = new ForParameterRegistration();
        Parameter parameter = new Parameter();
        parameter.registrateArgs(forReg);
        List<Args> args = parameter.getArgList();
        int size = args.size();
        assertEquals(1, size);
    }

    @Test
    public void testRegistrateArgsThrowNullPointerException() {

        Object value = null;
        Parameter parameter = new Parameter();
        Exception ex = assertThrows(NullPointerException.class,
                () -> parameter.registrateArgs(value));
        String message = ex.getMessage();
        assertTrue(message.contains("Parameter is null"));
    }

    /**
     * Test of getArgList method, of class Parameter.
     */
    @Test
    public void testGetArgList() {
        ForRegistration forReg = new ForParameterRegistration();
        Parameter parameter = new Parameter();
        parameter.registrateArgs(forReg);
        parameter.registrateArgs(2);
        List<Args> result = parameter.getArgList();
        assertEquals(2, result.size());
    }

    interface ForRegistration {

        void test();
    }

    class ForParameterRegistration implements ForRegistration {

        @Override
        public void test() {

        }

    }

}
