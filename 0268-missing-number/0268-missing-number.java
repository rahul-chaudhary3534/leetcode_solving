class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        // XOR from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        // XOR with array elements
        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}