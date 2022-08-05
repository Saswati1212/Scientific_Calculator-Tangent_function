import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class TanTestTest {

	/*
	 * Test to case to check Requirement1 : For any valid number
	 */
	@Test
	public void testForUserInput() throws Exception {
		TanModel calc = new TanModel();
		calc.setAngleForCalculator("1");
		assertTrue(!Double.isNaN(calc.calculateTanFunction()));

		calc.setAngleForCalculator("44.556");
		assertTrue(!Double.isNaN(calc.calculateTanFunction()));

		calc.setAngleForCalculator(String.valueOf(Math.PI));
		assertTrue(!Double.isNaN(calc.calculateTanFunction()));

		calc.setAngleForCalculator("244.92");
		assertTrue(!Double.isNaN(calc.calculateTanFunction()));

		calc.setAngleForCalculator("72.2");
		assertTrue(!Double.isNaN(calc.calculateTanFunction()));

		calc.setAngleForCalculator("-23.92");
		assertTrue(!Double.isNaN(calc.calculateTanFunction()));

		calc.setAngleForCalculator("123.92");
		assertTrue(!Double.isNaN(calc.calculateTanFunction()));

    }

    /*
	 * Test case to check Requirement 2 : If domain is not satisfied, tan(x) return
	 * NaN
	 */
    @Test
	public void testForDomain() throws Exception
    {
		TanModel calc = new TanModel();
		calc.setAngleForCalculator("90.0");
		assertTrue(Double.isNaN(calc.calculateTanFunction()));
    }


    /*
	 * Test case to check Requirement 3 : If input is non-numeric, exception is
	 * thrown for incorrect format
	 */
    @Test
	public void testForException() {

		final TanModel calculator = new TanModel();

		assertThrows(NumberFormatException.class, () -> {
			calculator.setAngleForCalculator("abc");
		});
    }


    /*
	 * Test case to check Requirement4 : if domain is satisfied, tan(x) returns
	 * computed value
	 */

    @Test
	public void testForCorrectDomain() throws Exception
    {
		TanModel calc = new TanModel();
		calc.setAngleForCalculator("40.0");
		assertTrue(!Double.isNaN(calc.calculateTanFunction()));
	}


}

