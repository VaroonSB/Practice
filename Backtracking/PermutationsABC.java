import java.util.*;

class StringPermutations {
    public List<String> permute(String str) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        backtrack(str, "", used, result);
        return result;
    }

    private void backtrack(String str, String current, boolean[] used, List<String> result) {
        if (current.length() == str.length()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;  // choose
                backtrack(str, current + str.charAt(i), used, result); // explore
                used[i] = false; // un-choose (backtrack)
            }
        }
    }

    public static void main(String[] args) {
        StringPermutations perm = new StringPermutations();
        List<String> permutations = perm.permute("abc");
        System.out.println(permutations);
    }
}