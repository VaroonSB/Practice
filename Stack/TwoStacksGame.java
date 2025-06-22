public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
    // Write your code here
    return count(a, b, 0, 0, maxSum) - 1;
}

private static int count(List<Integer> a, List<Integer> b, int sum, int i, int maxSum) {
    if (sum > maxSum) {
        return i;
    }

    if (a.isEmpty() || b.isEmpty()) {
        return i;
    }

    int left = count(new ArrayList<>(a.subList(1, a.size())), b, sum + a.get(0), i+1, maxSum);

    int right = count(a, new ArrayList<>(b.subList(1, b.size())), sum + b.get(0), i+1, maxSum);

    return Math.max(left, right);
}