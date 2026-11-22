
class Solution {
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Cannot reach current index
            if (i > maxReach) {
                return false;
            }

            // Update maximum reachable index
            maxReach = Math.max(maxReach, i + nums[i]);

            // Last index is reachable
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
