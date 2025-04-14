import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.print(subset(new int[]{2, 1, 2,}));
    }

    static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList());

        int start = 0;
        int end = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            start = 0;

            if (i > 0 && arr[i] == arr[i-1]) {
                start = end + 1;
            }

            end = outer.size() - 1;
            int n = outer.size();

            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }

        return outer;
    }
}