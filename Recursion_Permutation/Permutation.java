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

import java.util.*;

public class StringPermutations {
    public static void main(String[] args) {
        System.out.println(permutations("", "abc"));
    }

    static List<String> permutations(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < up.length(); i++) {
            char ch = up.charAt(i);
            result.addAll(permutations(p+ch, up.substring(0,i) + up.substring(i+1)));
        }

        return result;
    }
}
