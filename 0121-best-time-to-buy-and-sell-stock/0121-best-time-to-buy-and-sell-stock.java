class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0]; 
        int maxProfit = 0;

        for (int price : prices) {
            // If current price is lower than the buy price, update buy
            if (price < buy) {
                buy = price;
            }

            // Calculate profit
            int profit = price - buy;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}