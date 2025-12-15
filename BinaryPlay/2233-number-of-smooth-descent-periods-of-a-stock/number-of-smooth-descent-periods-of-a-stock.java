class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 1;
        int len = 1;
        int n = prices.length;

        for(int i = 1 ; i < n ; i++){
            if(prices[i] == prices[i - 1] - 1){
                len++;
            }else{
                len = 1;
            }
            total += len;
        }
        return total;
    }
}