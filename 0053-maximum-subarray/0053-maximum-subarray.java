class Solution {
    public int maxSubArray(int[] nums) {
        int ps = 0;
        int sum = 0;
        int maxs = nums[0];
        int l = nums.length;

        for(int i = 0; i < l; i++) {

            ps = sum + nums[i];

            if(ps > nums[i])
                sum = ps;
            else
                sum = nums[i];

            if(sum > maxs)
                maxs = sum;
        }

        return maxs;
    }
}