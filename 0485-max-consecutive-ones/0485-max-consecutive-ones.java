class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int c = 0;
        int maxc=0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==1){
                c++;
            }
            else if(nums[i] != 1){
                c=0;
            }

            if(c>maxc){
                maxc = c;
            }
        }
        return maxc;
        
    }
}