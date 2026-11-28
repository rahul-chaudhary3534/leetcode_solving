
class Solution {

    int[][][] dp;

    public boolean isScramble(String s1, String s2) {

        int n = s1.length();

        if (n != s2.length()) return false;

        dp = new int[n][n][n + 1];

        return solve(s1, s2, 0, 0, n);
    }

    private boolean solve(String s1, String s2,
                          int i, int j, int len) {

        // Already calculated
        if (dp[i][j][len] != 0) {
            return dp[i][j][len] == 1;
        }

        String a = s1.substring(i, i + len);
        String b = s2.substring(j, j + len);

        // Same substring
        if (a.equals(b)) {
            dp[i][j][len] = 1;
            return true;
        }

        // Check character frequency
        int[] freq = new int[26];

        for (int k = 0; k < len; k++) {
            freq[a.charAt(k) - 'a']++;
            freq[b.charAt(k) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                dp[i][j][len] = -1;
                return false;
            }
        }

        // Try every possible split
        for (int k = 1; k < len; k++) {

            // No swap
            boolean noSwap =
                solve(s1, s2, i, j, k) &&
                solve(s1, s2, i + k, j + k, len - k);

            if (noSwap) {
                dp[i][j][len] = 1;
                return true;
            }

            // Swap
            boolean swap =
                solve(s1, s2, i, j + len - k, k) &&
                solve(s1, s2, i + k, j, len - k);

            if (swap) {
                dp[i][j][len] = 1;
                return true;
            }
        }

        dp[i][j][len] = -1;
        return false;
    }
}
