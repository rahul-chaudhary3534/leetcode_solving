class Solution {
    public void rotate(int[] nums, int k) {
    
        int n = nums.length;
        k= k%n;
        rev(nums,0,n-k-1);
        rev(nums,n-k,n-1);
        rev(nums,0,n-1);
        
    }
    public void rev(int[] arr, int start, int end){
        while(start<end){
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
        return;
    }
}