class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<l ; i++){
            int x = nums[i];
            if(map.containsKey(target-x)){
                return new int[] {map.get(target-x), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
        
        
    }
}