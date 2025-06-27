class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return permutate(new ArrayList<Integer>(), list);
    }

    static List<List<Integer>> permutate(List<Integer> p, List<Integer> up) {
        if (up.isEmpty()) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList(p));
            return list;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < up.size(); i++) {
            int chosen = up.get(i);

            List<Integer> newP = new ArrayList<>(p);
            List<Integer> newUp = new ArrayList<>();

            newP.add(chosen);
            newUp.addAll(up.subList(0, i));
            newUp.addAll(up.subList(i+1, up.size()));

            result.addAll(permutate(newP, newUp));
        }

        return result;
    }
}


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        backtrack(list, new ArrayList(), nums, new boolean[nums.length]);

        return list;
    }

    static void backtrack(List<List<Integer>> result, List<Integer> process, int[] nums, boolean[] used) {
        if (process.size() == nums.length) {
            result.add(new ArrayList(process));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            process.add(nums[i]);
            used[i] = true;

            backtrack(result, process, nums, used);

            process.remove(process.size() - 1);
            used[i] = false;
        }
    }
}