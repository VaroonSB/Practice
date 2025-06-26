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