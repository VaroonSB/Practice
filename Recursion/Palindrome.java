class Main {
    public static void main(String[] args) {
        String str = "2332";
        System.out.println(palindrome(str, 0, str.length()-1));
    }

    static int palindrome(String str, int start, int end) {
        if (start > end) {
            return 1;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return 0;
        }

        return palindrome(str, start+1, end-1) * 1;
    }
}