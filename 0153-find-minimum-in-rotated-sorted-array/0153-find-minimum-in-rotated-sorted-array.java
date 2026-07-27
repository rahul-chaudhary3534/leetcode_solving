class Solution {
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            // Left half is sorted
            if (nums[l] <= nums[mid]) {
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            }
            // Right half is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                r = mid - 1;
            }
        }

        return ans;
    }
}