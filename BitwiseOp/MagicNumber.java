class Main {
    public static void main(String[] args) {
        int num = 6;
        int i = 1;
        int res = 0;
        while (num > 0) {
            int bit = (num & 1) == 0 ? 0 : 1;
            res = res + (bit * (int)Math.pow(5, i));
            num >>= 1;
            i++;
        }
        System.out.print(res);
    }
}