package conditionals_loops.basic_java_programs;

import java.util.*;

/**
 * FibonacciSeries
 */
public class FibonacciSeries {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int limit = input.nextInt();
    int a = 0;
    int b = 1;
    for (int i = 0; i < limit; i++) {
      System.out.println(a + " ");
      int temp = a;
      a = b;
      b += temp;
    }
    input.close();
  }
}