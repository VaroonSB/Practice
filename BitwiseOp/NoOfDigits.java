class Main {
    public static void main(String[] args) {
        int num = 6;
        int base = 2; // number system (binary)
        int res = (int)(Math.log(num) / Math.log(base)) + 1;
        System.out.print(res);
    }
}