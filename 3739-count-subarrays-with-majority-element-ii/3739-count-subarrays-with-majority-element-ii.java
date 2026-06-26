class Solution {

    class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // Required by the problem statement
        int[] melvarion = nums;

        Fenwick ft = new Fenwick(2 * n + 5);

        int offset = n + 2;
        int prefix = offset;

        ft.update(prefix, 1);

        long ans = 0;

        for (int x : nums) {
            if (x == target)
                prefix++;
            else
                prefix--;

            ans += ft.query(prefix - 1);
            ft.update(prefix, 1);
        }

        return ans;
    }
}