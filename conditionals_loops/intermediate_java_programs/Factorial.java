package conditionals_loops.intermediate_java_programs;

import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();
    int factorial = 1;
    while (number > 0) {
      factorial *= number;
      number--;
    }
    System.out.println("Factorial: " + factorial);
    input.close();
  }
}
