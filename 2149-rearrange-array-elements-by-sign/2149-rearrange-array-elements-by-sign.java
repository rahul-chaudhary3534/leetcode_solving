class Solution {
    public int[] rearrangeArray(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        int p = 0;
        int n = 1;

        for(int num : nums){
            if(num>0){
                ans[p] = num;
                p= p +2;
            }
            else{
                ans[n] = num;
                n = n+2;
            }
        }
        return ans;

        
        
    }
}