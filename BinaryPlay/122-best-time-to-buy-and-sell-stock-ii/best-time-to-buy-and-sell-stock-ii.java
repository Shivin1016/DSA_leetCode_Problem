class Solution {
    int n;
    int[][] t;
    public int solve(int[] nums , int i , int canBuy){

        if(i >= n) return 0;

        if(t[i][canBuy] != -1) return t[i][canBuy];

        int profit = 0;
        if(canBuy == 1){
            // buy or skip
            profit = Math.max(-nums[i] + solve(nums , i + 1 , 0) , solve(nums , i + 1 , 1));
        }else{
            // sell or hold
           profit = Math.max(+nums[i] + solve(nums , i + 1 , 1) , solve(nums , i + 1 , 0));
        } 

        return t[i][canBuy] = profit;
    }
    public int maxProfit(int[] prices) {
        n = prices.length;

        t = new int[n + 1][2];
        for(int[] r : t) Arrays.fill(r , -1);

        return solve(prices , 0 , 1);
    }
}