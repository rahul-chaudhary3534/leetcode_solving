class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] gcdCount = new long[max + 1];

        // Count pairs having gcd exactly i
        for (int i = max; i >= 1; i--) {
            long count = 0;

            for (int j = i; j <= max; j += i) {
                count += freq[j];
                gcdCount[i] -= gcdCount[j];
            }

            gcdCount[i] += count * (count - 1) / 2;
        }

        // Prefix sums
        for (int i = 2; i <= max; i++) {
            gcdCount[i] += gcdCount[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = upperBound(gcdCount, queries[i]);
        }

        return ans;
    }

    private int upperBound(long[] prefix, long target) {
        int left = 0, right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}