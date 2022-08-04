import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class TanTestTest {

    /*
     * Test case to check ETRN-REQ-4 : When input is non-numeric, Incorrect format exception is thrown.
     */
    @Test
    public void testException() {

        final TanModel objCalculator = new TanModel();

        assertThrows(NumberFormatException.class, () -> {
            objCalculator.setAngle("abc");
        });
    }


    /*
     * Test case to check ETRN-REQ-3 : tan(x) return NaN when domain is not satisfied
     */
    @Test
    public void testDomain() throws Exception
    {
        TanModel objCalculator = new TanModel();
        objCalculator.setAngle("90.0");
        assertTrue(Double.isNaN(objCalculator.calculateTangent()));
    }

    /*
     * Test case to check ETRN-REQ-2 : tan(x) returns calculated value when domain is satisfied
     */
    @Test
    public void testCorrectDomain() throws Exception
    {
        TanModel objCalculator = new TanModel();
        objCalculator.setAngle("40.0");
        assertTrue(!Double.isNaN(objCalculator.calculateTangent()));
    }

    /*
     * Test to case to check ETRN-REQ-1 : User can enter any valid number
     */
    @Test
    public void testInput()throws Exception
    {
        TanModel objCalculator = new TanModel();
        objCalculator.setAngle("1");
        assertTrue(!Double.isNaN(objCalculator.calculateTangent()));

        objCalculator.setAngle("44.556");
        assertTrue(!Double.isNaN(objCalculator.calculateTangent()));

        objCalculator.setAngle(String.valueOf(Math.PI));
        assertTrue(!Double.isNaN(objCalculator.calculateTangent()));
        
        objCalculator.setAngle("244.92");
        assertTrue(!Double.isNaN(objCalculator.calculateTangent()));
        
        objCalculator.setAngle("72.2");
        assertTrue(!Double.isNaN(objCalculator.calculateTangent()));
        
        objCalculator.setAngle("-23.92");
        assertTrue(!Double.isNaN(objCalculator.calculateTangent()));
        
        objCalculator.setAngle("123.92");
        assertTrue(!Double.isNaN(objCalculator.calculateTangent()));
        
      
        
        

    }
}

