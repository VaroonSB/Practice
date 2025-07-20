import java.util.Arrays;

public class Mo {

    public static int query(int[] blocks, int[] arr, int l, int r, int sqrt) {
        int ans = 0;
        int left = l;
        int right = r;

        // left
        while (l % sqrt != 0 && l < r && l != 0) {
            ans += arr[l];
            l++;
        }

        // middle
        while (l + sqrt <= r) {
            ans += blocks[l/sqrt];
            l += sqrt;
        }

        // right
        while (l <= r) {
            ans += arr[l];
            l++;
        }

        System.out.println("Query " + left + " to " + right + " : " + ans);
        return ans;
    }

    public static void update(int[] blocks, int[] arr, int index, int val, int sqrt) {
        int block_id = index / sqrt;
        blocks[block_id] += val - arr[index];
        arr[index] = val;
        System.out.println("Updated: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        System.out.println("Array: " + Arrays.toString(arr));

        int n = arr.length;

        // preprocess
        int sqrt = (int) Math.sqrt(n);

        int block_id = -1;

        int[] blocks = new int[sqrt +
                               1]; // you can't exactly contain in sqrt, so 1 added in case of
        // non-sqrt numbers

        for (int i = 0; i < n; i++) {
            if (i % sqrt == 0) {
                block_id++;
            }

            blocks[block_id] += arr[i];
        }

        query(blocks, arr, 2, 5, sqrt);

        update(blocks, arr, 2, 8, sqrt);
        query(blocks, arr, 2, 5, sqrt);
    }
}
