package conditionals_loops.basic_java_programs;

import java.util.Scanner;

public class LargestOfAllTill0 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int largest = 0;
    while (true) {
      int number = input.nextInt();
      if (number != 0) {
        if (number > largest) {
          largest = number;
        }
      } else {
        break;
      }
    }
    System.out.println("Largest: " + largest);
    input.close();
  }
}
