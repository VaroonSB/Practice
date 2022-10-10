package first_java;

import java.util.Scanner;

public class InterestCalculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter principal: ");
    double principal = input.nextDouble();
    System.out.println("\nEnter time: ");
    double time = input.nextDouble();
    System.out.println("\nEnter rate: ");
    double rate = input.nextDouble();
    double interest = (principal * time * rate) / 100;
    System.out.println("Interest = " + interest);
    input.close();
  }
}
