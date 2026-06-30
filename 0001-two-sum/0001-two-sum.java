class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                int x = map.get(target-nums[i]);
                arr[0] = x;
                arr[1] = i;
                return arr;

                
            }
            else{
                map.put(nums[i],i);
            }
        }
        return arr;

        
        
    }
}