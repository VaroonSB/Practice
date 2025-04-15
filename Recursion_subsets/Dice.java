import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.print(dice("", 4));
    }

    static List<String> dice(String p, int target) {
        if (target == 0) {
            // System.out.println(p);
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            result.addAll(dice(p+i, target-i));
        }

        return result;
    }

}