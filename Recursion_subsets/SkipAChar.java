class Main {
    public static void main(String[] args) {
        System.out.print(skipAChar("basfbacab", 0));
    }

    static String skipAChar(String str, int i) {

        if (i == str.length()) {
            return "";
        }

        if (str.charAt(i) == 'a') {
            return skipAChar(str, i+1);
        }

        return str.charAt(i) + skipAChar(str, i+1);
    }
}