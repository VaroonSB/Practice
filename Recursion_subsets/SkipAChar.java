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

class Main {
    public static void main(String[] args) {
        System.out.print(skipAChar("", "basfbacab"));
    }

    static String skipAChar(String p, String unp) {

        if (unp.isEmpty()) {
            return p;
        }

        char ch = unp.charAt(0);

        if (ch == 'a') {
            return skipAChar(p, unp.substring(1));
        } else {
            return skipAChar(p+ch, unp.substring(1));
        }
    }
}