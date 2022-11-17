package first_java;

import java.util.Scanner;

public class FibonacciSeries {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int limit = input.nextInt();
    int first = 1;
    int second = 1;
    System.out.println(0 + " ");
    for (int i = 0; i < limit; i++) {
      System.out.println(first + " ");
      int temp = first;
      first = second;
      second += temp;
    }
    input.close();
  }
}