package first_java;

import java.util.Scanner;

public class Armstrong {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int limit1 = input.nextInt();
    int limit2 = input.nextInt();
    for (int i = limit1; i < limit2; i++) {
      int n = i;
      int sum = 0;
      while (n > 0) {
        int remainder = n % 10;
        sum += (remainder * remainder * remainder);
        n /= 10;
      }
      if (sum == i) {
        System.out.println(i + " ");
      }
    }
    input.close();
  }
}
