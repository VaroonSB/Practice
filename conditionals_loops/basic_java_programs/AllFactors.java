package conditionals_loops.basic_java_programs;

import java.util.Scanner;

public class AllFactors {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();
    int temp = number / 2;
    while (temp > 0) {
      if (number % temp == 0) {
        System.out.println(temp + " ");
      }
      temp--;
    }
    input.close();
  }
}
