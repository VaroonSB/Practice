package first_java;

import java.util.Scanner;

public class FibonacciSeries {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int limit = input.nextInt();
    int first = 0;
    int second = 1;
    for (int i = 0; i < limit; i++) {
      System.out.println(first + " ");
      int sum = first + second;
      first = second;
      second = sum;
    }
    input.close();
  }
}