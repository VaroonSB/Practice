package first_java;

import java.util.*;

public class GreetingName {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String name = input.nextLine();
    System.out.println("Hello, " + name);
    input.close();
  }
}
