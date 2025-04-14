import java.util.*;

class Main {
    public static void main(String[] args) {
        subsequence("", "abc");
    }

    static void subsequence(String p, String unp) {
        if (unp.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = unp.charAt(0);

        subsequence(p+ch, unp.substring(1));
        subsequence(p, unp.substring(1));
    }
}

class Main {
    public static void main(String[] args) {
        System.out.print(subsequence("", "abc"));
    }

    static ArrayList<String> subsequence(String p, String unp) {
        if (unp.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            if (!p.isEmpty()) {
                list.add(p);
            }
            return list;
        }

        char ch = unp.charAt(0);

        ArrayList<String> left = subsequence(p+ch, unp.substring(1));
        ArrayList<String> right = subsequence(p, unp.substring(1));

        left.addAll(right);

        return left;
    }
}