import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        // Create a copy of original array
        int[] sorted = arr.clone();
        
        // Sort the copied array
        Arrays.sort(sorted);
        
        // Map each unique number to its rank
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int rank = 1;
        
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }
        
        // Replace each element with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        
        return arr;
    }
}