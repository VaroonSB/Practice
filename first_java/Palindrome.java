package first_java;

import java.util.Scanner;

public class Palindrome {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str = input.nextLine();
    String temp = "";
    for (int i = 0; i < str.length(); i++) {
      temp = temp + str.charAt(str.length() - (i + 1));
    }
    if (temp.equals(str)) {
      System.out.println("Palindrome");
    } else {
      System.out.println("Not a palindrome");
    }
    input.close();
  }
}
