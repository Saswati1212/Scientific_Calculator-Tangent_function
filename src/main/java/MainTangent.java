
import java.util.InputMismatchException;
import java.util.Scanner;
import main.java.TanModel;
public class MainTangent {

    public static void main(String[] args) {
        TanModel objCalculator = new TanModel();
        boolean keepCalculating = true;
        Scanner objScanner;
        do {
            try {
                printMenu();
                objScanner = new Scanner(System.in);
                String userInput = objScanner.nextLine();

                switch (Integer.parseInt(userInput)) {
                    case 1:
                        System.out.println("Enter angle(degrees) : ");
                        String inputAngle = objScanner.nextLine();
                        objCalculator.setAngle(inputAngle);
                        System.out.println("Result : " + objCalculator.calculateTangent());
                        break;
                    case 2:
                        keepCalculating = false;
                        break;
                    default:
                        System.out.println("No such option available. ");
                }
            } catch (ArithmeticException ex) {
                ex.getMessage();
            } catch (InputMismatchException ex) {
                System.out.println("Wrong Input. Please try again.");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (keepCalculating);
    }

    public static void printMenu() {
        System.out.println("\n");
        System.out.println("Scientific Calculator");
        System.out.println("Operation : tan(x)");
        System.out.println("1. Enter value for x : angle(degrees)");
        System.out.println("2. Exit Calculator");
        System.out.println("Enter Choice : ");
    }
}