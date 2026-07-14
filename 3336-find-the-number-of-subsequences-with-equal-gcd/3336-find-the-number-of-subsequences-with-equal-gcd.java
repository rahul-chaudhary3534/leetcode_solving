class Solution {
    public int subsequencePairCount(int[] nums) {
        int MOD = 1_000_000_007;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long[][] dp = new long[max + 1][max + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            long[][] next = new long[max + 1][max + 1];

            for (int gcd1 = 0; gcd1 <= max; gcd1++) {
                for (int gcd2 = 0; gcd2 <= max; gcd2++) {

                    if (dp[gcd1][gcd2] == 0) {
                        continue;
                    }

                    long ways = dp[gcd1][gcd2];

                    // Case 1: Don't put num in either subsequence
                    next[gcd1][gcd2] =
                        (next[gcd1][gcd2] + ways) % MOD;

                    // Case 2: Put num in first subsequence
                    int newGcd1 = (gcd1 == 0) ? num : gcd(gcd1, num);

                    next[newGcd1][gcd2] =
                        (next[newGcd1][gcd2] + ways) % MOD;

                    // Case 3: Put num in second subsequence
                    int newGcd2 = (gcd2 == 0) ? num : gcd(gcd2, num);

                    next[gcd1][newGcd2] =
                        (next[gcd1][newGcd2] + ways) % MOD;
                }
            }

            dp = next;
        }

        long answer = 0;

        for (int g = 1; g <= max; g++) {
            answer = (answer + dp[g][g]) % MOD;
        }

        return (int) answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}