package first_java;

import java.util.Scanner;

public class LargestNumber {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double number1 = input.nextDouble();
    double number2 = input.nextDouble();
    if (number1 > number2) {
      System.out.println(number1);
    } else {
      System.out.println(number2);
    }
    input.close();
  }
}
