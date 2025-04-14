import java.util.*;

class Main {
    public static void main(String[] args) {
        permutation("", "abc");
    }

    static void permutation(String p, String unp) {
        if (unp.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = unp.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());

            permutation(first + ch + second, unp.substring(1));
        }
    }


}