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

class Solution {

    static Map<Integer, String> letterMap = Map.of(
            2, "abc", 3, "def", 4, "ghi", 5, "jkl",
            6, "mno", 7, "pqrs", 8, "tuv", 9, "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        return combinations("", digits);
    }

    static List<String> combinations(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            if (!p.isEmpty()) {
                list.add(p);
            }
            return list;
        }

        int digit = up.charAt(0) - '0';

        String letters = letterMap.get(digit);
        System.out.print(letters);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < letters.length(); i++) {

            char ch = letters.charAt(i);

            result.addAll(combinations(p+ch, up.substring(1)));
        }

        return result;
    }
}