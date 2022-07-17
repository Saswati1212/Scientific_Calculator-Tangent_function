import java.util.Scanner;
public class Main_tangent {

        public static void main(String[] args) {

            boolean keepCalculating = true;
            Scanner objScanner;
            do {
                try {
                    printMenu();
                    objScanner = new Scanner(System.in);
                    int userInput = Integer.parseInt(objScanner.nextLine());

                    switch (userInput) {
                        case 1:
                            //get angle function


                            break;
                        default:
                            System.out.println("No such option available. ");
                    }

                } catch (ArithmeticException ex) {
                    ex.getMessage();

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
            System.out.println("Enter Choice : ");
        }
    }




