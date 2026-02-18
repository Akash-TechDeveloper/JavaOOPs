package Advanced_Calculator;
import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        char choice;
        AdvancedCalculation calculation = new AdvancedCalculation();

        do {
            double num1;
            while (true) {
                System.out.print("Enter First Number: ");
                try {
                    num1 = sr.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number like 123 or 45.67 ");
                    sr.next();
                }
            }
            char operator;
            while (true) {
                System.out.print("Enter Operator to solve ");
                try {
                    operator = sr.next().charAt(0);
                    if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                        break;
                    } else {
                        System.out.println(" Invalid operator! Use only +, -, *, /.");
                    }
                } catch (Exception e) {
                    System.out.println(" Wrong Operators Try again ");
                    sr.next();
                }
            }
            double num2;
            while (true) {
                System.out.print("Enter Second Number: ");
                try {
                    num2 = sr.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number like e.g;242");
                    sr.next();
                }
            }
            double result = calculation.calculate(num1, num2, operator);
            System.out.println("Result: " + result);

            System.out.print("Type 0 to exit or 1 to continue: ");
            choice = sr.next().charAt(0);

        } while (choice != '0');

        calculation.showHistory();

//        do{
//            double num1 = 0;
//            char operator='-';
//            double num2 = 0;
//            double result;
//            System.out.println("Enter First Number : ");
//            try {
//                num1 = sr.nextDouble();
//            }
//            catch (Exception e){
//                System.out.println("Use Numbers  like e.g;123 ");
//            }
//            System.out.println("Enter Any Operator ");
//            try {
//                operator = sr.next().charAt(0);
//            }
//            catch (Exception e){
//                System.out.println("Use single Operator e.g; -,+,/,*");
//            }
//            System.out.println("Enter Second Number : ");
//            try {
//                num2 = sr.nextDouble();
//            }
//            catch (Exception e){
//                System.out.println("Enter only Numbers like ");
//            }
//            result = calculation.calculate(num1, num2, operator);
//            System.out.println("Result : " + result);
//
//            System.out.println("Type 0 to exit 1 to continue");
//            choice = sr.next().charAt(0);
//        }
//        while (choice!='0');
//        calculation.showHistory();

    }
}
