class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int mp = 0;
        for(int price : prices){
            if(price<buy) buy = price;
            int p = price - buy;
            if(p>mp) mp = p;       
            
        }
        return mp;
        
    }
}