import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.print(permutation("", "abc"));
    }

    static List<String> permutation(String p, String unp) {
        if (unp.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = unp.charAt(0);

        List<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());

            ans.addAll(permutation(first + ch + second, unp.substring(1)));
        }

        return ans;
    }


}