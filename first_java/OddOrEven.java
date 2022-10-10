package first_java;

import java.util.*;

/**
 * OddOrEven
 */
public class OddOrEven {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();
    if (number % 2 == 0) {
      System.out.println(number + " is even");
    } else {
      System.out.println(number + " is odd");
    }
    input.close();
  }
}