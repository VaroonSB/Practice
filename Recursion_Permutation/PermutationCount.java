import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.print(permutationCount("", "abcd"));
    }

    static int permutationCount(String p, String unp) {
        if (unp.isEmpty()) {
            // System.out.println(p);
            return 1;
        }

        char ch = unp.charAt(0);

        int count = 0;

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());

            count = count + permutationCount(first + ch + second, unp.substring(1));
        }

        return count;
    }


}