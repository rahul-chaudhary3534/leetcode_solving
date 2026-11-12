class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            fun(n, i, arr);
        }

        return arr;
        
    }
    public void fun(int n, int curr, List<Integer> arr ){
        if(curr>n) return;
        arr.add(curr);
        for(int i = 0; i<=9; i++){
            if (curr * 10 + i <= n) {
                fun(n, curr * 10 + i, arr);
            }
        }


    }
}