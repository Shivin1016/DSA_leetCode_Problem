class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long[] profit = new long[n];
        long totalProfit = 0;
        for(int i = 0 ; i < n ; i++){
            profit[i] = (long)(prices[i] * strategy[i]);
            totalProfit += profit[i];
        }

        int i = 0 , j = 0;
        long maxGain = 0;
        //profits for particular windows 
        long originalProfit = 0;
        long modifiedProfit = 0; 

        while(j < n){
            // current window profit without modification
            originalProfit += profit[j];

            //agar ham window of k ke right half part me a gaye then add price value
            if((j - i + 1) > k / 2){
                modifiedProfit += prices[j];
            }
            //out of window --> window shrink kro
            if((j - i + 1) > k){
                modifiedProfit -= prices[i + k / 2]; //at half index 
                originalProfit -= profit[i];
                i++;
            }
            

            if(j - i + 1 == k){
                //got subarray of k size 
                maxGain = Math.max(maxGain , modifiedProfit - originalProfit);
            }

            j++;
        } 
        
        return totalProfit + (maxGain < 0 ? 0 : maxGain);
    }
}