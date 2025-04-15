class Solution {
    public List<String> letterCombinations(String digits) {
        combinations("", digits);
        return new ArrayList<String>();
    }

    static void combinations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // convert '2' to 2

        // 1 - abc, b - def, c - ghi, etc
        // at each of the posible digits, pick one.
        // input - 23, output - dg, dh, di, eg, eh, etc
        for (int i = (digit-1) * 3; i < digit*3; i++) {

            char ch = (char) ('a' + i);

            combinations(p+ch, up.substring(1));
        }
    }
}