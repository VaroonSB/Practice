package first_java;

import java.util.Scanner;

public class Currency {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double rupee = input.nextDouble();
    double usd = rupee / 72.5;
    System.out.println("USD: " + usd);
    input.close();
  }
}
