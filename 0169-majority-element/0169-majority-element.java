class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> val = new HashMap<>();
        int x = nums.length;

        for(int i = 0; i<x;i++){
            if(val.containsKey(nums[i])){
                int j = val.get(nums[i]);
                val.put(nums[i],j+1);
            }
            else val.put(nums[i],1);
        }
        for(int i : val.keySet()){
            if(val.get(i)>x/2){
                return i;
            }
        }

        return -1;
        
    }
}