class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int linear_sum = maxSubArray(nums);
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum = sum + nums[i];
            nums[i] = nums[i] * -1;

        }
        int mid = maxSubArray(nums);
        int circular_sum = sum + mid;
        if(circular_sum ==0) return linear_sum;
        return Math.max(linear_sum, circular_sum);
        
    }
     public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            ans = Math.max(ans, sum);
            if(sum < 0) sum = 0;
           
        }

        return ans;
    }
}