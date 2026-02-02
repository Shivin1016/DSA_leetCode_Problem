class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] nextGreaterElem = new int[n]; 
        int maxEle = prices[n - 1];
        int cost = 0;
        for(int i = n - 2 ; i >= 0 ; i--){
            maxEle = Math.max(prices[i] , maxEle);
            cost = Math.max(cost , maxEle - prices[i]);
        }

        return cost;
    }
}