class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();

        int insertions = 0;
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            // Maintain only '(' in stack
            if (ch == '(') {
                stack.push(ch);
                i++;
            } else {
                // if consecutive '))' ?
                if (i + 1 < s.length() && s.charAt(i+1) == ')') {
                    // if stack has a '('
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        // else, we need one open bracket
                        insertions++;
                    }
                    // move past two
                    i = i + 2;
                } else {
                    // if there's no consecutive ))
                    insertions++;
                    // if stack has a '('
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        // else, we need one open bracket
                        insertions++;
                    }
                    i++;
                }
            }
        }

        // insertions and remainin ( in stack needs two closing brackets
        return insertions + (stack.size() * 2);
    }
}