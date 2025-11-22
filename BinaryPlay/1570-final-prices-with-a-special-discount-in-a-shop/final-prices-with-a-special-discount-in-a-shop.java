class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;

        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            boolean notFound = false;
            for(int j = i + 1 ; j < n ; j++){
                if(prices[i] >= prices[j]){
                    ans[i] = prices[i] - prices[j];
                    notFound = true;
                    break;
                }
            }
            if(notFound == false){
                ans[i] = prices[i]; // no discount found
            }
        }
        return ans;
    }
}