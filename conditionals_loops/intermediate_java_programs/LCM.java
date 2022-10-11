package conditionals_loops.intermediate_java_programs;

import java.util.Scanner;

public class LCM {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number1 = input.nextInt();
    int number2 = input.nextInt();
    int lcm = Math.max(number1, number2);
    while (true) {
      if (lcm % number1 == 0 && lcm % number2 == 0) {
        break;
      }
      lcm++;
    }
    System.out.println("LCM: " + lcm);
    input.close();
  }
}
