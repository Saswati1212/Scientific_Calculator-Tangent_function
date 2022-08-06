import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * main class for function tan(x)
 *
 * @author Saswati Chowdhury
 */
public class MainTangent {
  /**
   * Main function for the program that executes
   *
   * @param args default arguments
   */
  public static void main(String[] args) {
    TanModel objTan = new TanModel();
    boolean calculateTan = true;
    Scanner scanner;
    do {
      try {
        startCalculator();
        scanner = new Scanner(System.in);
        String enterInput = scanner.nextLine();

        switch (Integer.parseInt(enterInput)) {
          case 1:
            System.out.println("Enter angle in degrees : ");
            String inputForAngle = scanner.nextLine();
            objTan.setAngleForCalculator(inputForAngle);
            System.out.println("Result : " + objTan.calculateTanFunction());
            System.out.println("Result with sin(x)/cos(x)" + objTan.sinCosCalculating());
            break;
          case 2:
            calculateTan = false;
            break;
          default:
            System.out.println("No such choice is offered.");
        }
      } catch (ArithmeticException ex) {
        ex.getMessage();
      } catch (InputMismatchException ex) {
        System.out.println("Wrong Input. Please enter a valid angle.");
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    } while (calculateTan);
  }

  /** show calculator menu for tan(x) function */
  public static void startCalculator() {
    System.out.println("\n");
    System.out.println("tan(x) Calculator");
    System.out.println("1. Enter the value of x : angle(degrees)");
    System.out.println("2. Exit Calculator");
    System.out.println("Enter your Choice : ");
  }
}
