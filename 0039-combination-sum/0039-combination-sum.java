class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        fun(candidates, target, arr, 0, curr);
        return arr;
        
    }
    public void fun(int[] candidates, int target,List<List<Integer>> arr, int idx , List<Integer>  curr ){
        if(target==0){
             arr.add(new ArrayList<>(curr));
            return;


        }
        for(int i = idx; i<candidates.length; i++){
            if(target>=candidates[i]){
                curr.add(candidates[i]);
                fun(candidates, target-candidates[i], arr, i, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}