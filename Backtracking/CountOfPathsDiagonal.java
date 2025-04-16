import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println(uniquePaths("", 3, 3));
    }

    static List<String> uniquePaths(String path, int m, int n) {
        if (m == 1 && n == 1) {
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        List<String> result = new ArrayList<>();

        if (m > 1) {
            result.addAll(uniquePaths(path + 'D', m-1, n));
        }

        if (n > 1) {
            result.addAll(uniquePaths(path + 'R', m, n-1));
        }

        if (m > 1 && n > 1) {
            result.addAll(uniquePaths(path + 'C', m-1, n-1));
        }

        return result;
    }
}