class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n+1];

        for (int i = 2; i * i <= n; i++) {
            if(!primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                count++;
            }
        }

        return count;
    }
}