package conditionals_loops;

import java.util.Scanner;

public class SubProdNSumOfDigits {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int sum = 0;
    int prod = 1;
    int number = input.nextInt();
    while (number > 0) {
      int remainder = number % 10;
      sum += remainder;
      prod *= remainder;
      number /= 10;
    }
    System.out.println("Result: " + (prod - sum));
    input.close();
  }
}
