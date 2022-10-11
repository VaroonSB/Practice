package conditionals_loops.intermediate_java_programs;

import java.util.Scanner;

public class ReverseAString {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str = input.nextLine();
    String temp = "";
    for (int i = str.length(); i > 0; i--) {
      temp += str.charAt(i - 1);
    }
    System.out.println("Reversed string: " + temp);
    input.close();
  }
}
