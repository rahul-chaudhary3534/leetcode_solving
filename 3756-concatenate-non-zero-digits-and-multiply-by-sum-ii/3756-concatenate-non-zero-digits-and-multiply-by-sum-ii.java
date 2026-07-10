import java.util.*;

class Solution {

    private static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // Store positions of all non-zero digits
        ArrayList<Integer> positions = new ArrayList<>();

        // Store the actual non-zero digits
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int digit = s.charAt(i) - '0';

            if (digit != 0) {
                positions.add(i);
                digits.add(digit);
            }
        }

        int m = digits.size();


        // -------------------------------------------
        // prefixNumber[i] = number formed by first i
        // non-zero digits, modulo MOD
        // -------------------------------------------

        long[] prefixNumber = new long[m + 1];

        // prefixSum[i] = sum of first i non-zero digits
        long[] prefixSum = new long[m + 1];

        // pow10[i] = 10^i % MOD
        long[] pow10 = new long[m + 1];

        pow10[0] = 1;

        for (int i = 0; i < m; i++) {

            int digit = digits.get(i);

            prefixNumber[i + 1] =
                (prefixNumber[i] * 10 + digit) % MOD;

            prefixSum[i + 1] =
                prefixSum[i] + digit;

            pow10[i + 1] =
                (pow10[i] * 10) % MOD;
        }


        // -------------------------------------------
        // Answer queries
        // -------------------------------------------

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int l = queries[q][0];
            int r = queries[q][1];


            // First non-zero digit whose original
            // position is >= l
            int left = lowerBound(positions, l);


            // First non-zero digit whose original
            // position is > r
            int right = upperBound(positions, r);


            // No non-zero digit in this range
            if (left == right) {
                answer[q] = 0;
                continue;
            }


            // Number of non-zero digits in query
            int len = right - left;


            // Extract concatenated number x
            long x = (
                prefixNumber[right]
                - (prefixNumber[left] * pow10[len]) % MOD
                + MOD
            ) % MOD;


            // Sum of digits
            long sum =
                prefixSum[right] - prefixSum[left];


            // Final answer
            answer[q] = (int) ((x * (sum % MOD)) % MOD);
        }

        return answer;
    }


    // First index where list[index] >= target
    private int lowerBound(ArrayList<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    // First index where list[index] > target
    private int upperBound(ArrayList<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}