package first_java;

import java.util.Scanner;

public class Operator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double number1 = input.nextDouble();
    double number2 = input.nextDouble();
    String op = input.next();
    double result = 0;
    if (op.equals("+")) {
      result = number1 + number2;
    } else if (op.equals("-")) {
      result = number1 - number2;
    } else if (op.equals("*")) {
      result = number1 * number2;
    } else if (op.equals("/")) {
      result = number1 / number2;
    }
    System.out.println("\nResult: " + result);
    input.close();
  }
}
