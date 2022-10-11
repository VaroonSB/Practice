package conditionals_loops.basic_java_programs;

import java.util.Scanner;

public class SumOfAllTill0 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int sum = 0;
    while (true) {
      int number = input.nextInt();
      if (number != 0) {
        sum += number;
      } else {
        break;
      }
    }
    System.out.println("Sum: " + sum);
    input.close();
  }
}
