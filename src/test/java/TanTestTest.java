import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TanTestTest {

  /**
   * Test to case to check FR1 : For any valid number
   *
   * @throws Exception NumberFormat Exception
   */
  @Test
  public void testForUserInput() throws Exception {
    TanModel calc = new TanModel();
    calc.setAngleForCalculator("1");
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));

    calc.setAngleForCalculator("41.558");
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));

    calc.setAngleForCalculator(String.valueOf(Math.PI));
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));

    calc.setAngleForCalculator("244.92");
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));

    calc.setAngleForCalculator("71.2");
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));

    calc.setAngleForCalculator("-23.89");
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));

    calc.setAngleForCalculator("124.87");
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));
  }

  /**
   * Test case for valid user input
   *
   * @throws Exception NumberFormat Exception
   */
  @Test
  public void testForUserInput2() throws Exception {
    TanModel calc = new TanModel();
    calc.setAngleForCalculator("2");
    assertTrue(!Double.isNaN(calc.sinCosCalculating()));

    calc.setAngleForCalculator("41.558");
    assertTrue(!Double.isNaN(calc.sinCosCalculating()));

    calc.setAngleForCalculator("-23.89");
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));
  }

  /**
   * Test case to check FR2 : If domain is not satisfied, tan(x) return NaN
   *
   * @throws Exception NumberFormat Exception
   */
  @Test
  public void testForDomain() throws Exception {
    TanModel calc = new TanModel();
    calc.setAngleForCalculator("90.0");
    assertTrue(Double.isNaN(calc.calculateTanFunction()));
  }

  /** Test case to check FR2 for domain 2 */
  @Test
  public void testForDomain2() {
    TanModel calc = new TanModel();
    calc.setAngleForCalculator("90.0");
    assertTrue(Double.isNaN(calc.sinCosCalculating()));
  }

  /** Test case to check FR3 : If input is non-numeric, exception is thrown for incorrect format */
  @Test
  public void testForException() {

    final TanModel calculator = new TanModel();

    assertThrows(
        NumberFormatException.class,
        () -> {
          calculator.setAngleForCalculator("xyz");
        });
  }

  /**
   * Test case to check FR4 : if domain is satisfied, tan(x) returns computed value
   *
   * @throws Exception NumberFormat Exception
   */
  @Test
  public void testForCorrectDomain() throws Exception {
    TanModel calc = new TanModel();
    calc.setAngleForCalculator("30.0");
    assertTrue(!Double.isNaN(calc.calculateTanFunction()));
  }

  /** Test case for factorial */
  @Test
  public void testForFactorial() {

    assertEquals(24, TanModel.fact(4));
  }

  /** Test case for sin(x) evaluation */
  @Test
  public void testForSin() {
    double b = TanModel.sinVal(30);
    System.out.println(b);
    assertEquals(0.49999999999999994, b);
  }

  /** Test case for cos(x) evaluation */
  @Test
  public void testForCos() {
    double b = TanModel.cosCalculate(30);
    System.out.println(b);
    assertEquals(0.8660254037844386, b);
  }

  /** Test case for sin-cos evaluation */
  @Test
  public void testFortanUsingSinCos() {
    double b = TanModel.sinCosApprox(60);
    System.out.println(b);
    assertEquals(1.7320508075688765, b);
  }
}
