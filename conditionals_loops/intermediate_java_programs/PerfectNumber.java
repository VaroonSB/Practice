package conditionals_loops.intermediate_java_programs;

import java.util.Scanner;

public class PerfectNumber {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();
    int sum = 0;
    for (int i = 1; i <= (number / 2); i++) {
      if (number % i == 0) {
        sum += i;
      }
    }
    if (sum == number) {
      System.out.println("Perfect number");
    } else {
      System.out.println("Not a Perfect number");
    }
    input.close();
  }
}
