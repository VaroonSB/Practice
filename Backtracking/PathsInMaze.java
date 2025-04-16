import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println(uniquePaths("", 3, 2));
    }

    static List<String> uniquePaths(String path, int m, int n) {
        if (m == 1 && n == 1) {
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();
        if (m >= 1) {
            left = uniquePaths(path + 'D', m-1, n);
        }

        if (n >= 1) {
            right = uniquePaths(path + 'R', m, n-1);
        }

        left.addAll(right);
        return left;
    }
}