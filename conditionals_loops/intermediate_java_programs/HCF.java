package conditionals_loops.intermediate_java_programs;

import java.util.Scanner;

public class HCF {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number1 = input.nextInt();
    int number2 = input.nextInt();
    int min = Math.min(number1, number2);
    while (min > 0) {
      if (number1 % min == 0 && number2 % min == 0) {
        break;
      }
      min--;
    }
    System.out.println("HCF: " + min);
    input.close();
  }
}
