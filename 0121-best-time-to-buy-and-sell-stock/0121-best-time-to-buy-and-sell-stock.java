class Solution {
    public int maxProfit(int[] prices) {
        // int profit = 0;
        // int min = prices[0];
        // for(int i=1; i<prices.length; i++){
        //     int cost = prices[i] - min;
        //     profit = profit>cost?profit:cost;
        //     min = prices[i]<min?prices[i]:min;
        // }
        // return profit;
        int n = prices.length;
        int[] buy = new int[n];
        buy[0] = prices[0];
        for(int i=1; i<n; i++){
            buy[i] = Math.min(buy[i-1], prices[i]);
        }
        int[] sell = new int[n];
        sell[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--){
            sell[i] = Math.max(prices[i], sell[i+1]);
        }
        int profit = 0;
        for(int i=0; i<n; i++){
            profit = Math.max(profit, sell[i] - buy[i]);
        }
        return profit;
    }
}