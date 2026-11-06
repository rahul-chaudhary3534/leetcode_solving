class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int si = 0; // start index
        int ei = 0; // end index
        int p = 1;
        int ans = 0;
        while(ei<nums.length){
            //growing
            p *= nums[ei];
            // shrinking
            while(p>=k && si<= ei){
                p /= nums[si];
                si++;
            }
            ans = ans + (ei - si + 1); // adding window size to ans
            ei++;

        }
        return ans;
        
    }
}