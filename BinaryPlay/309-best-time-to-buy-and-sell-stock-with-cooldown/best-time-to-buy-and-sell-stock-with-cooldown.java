class Solution {
    int n;
    int[][] t;
    public int solve(int[] prices , int i , int canBuy){
        if(i >= n) return 0;

        if(t[i][canBuy] != -1) return t[i][canBuy];

        if(canBuy == 1){
            return t[i][canBuy] = Math.max(-prices[i] + solve(prices , i + 1 , 0) , solve(prices , i + 1 , 1));
        }
        // cooldown so increment i + 2 after sell
        return t[i][canBuy] = Math.max(+prices[i] + solve(prices , i + 2 , 1) , solve(prices , i + 1 , 0)); 
    }
    public int maxProfit(int[] prices) {
        n = prices.length;

        t = new int[5001][2];
        for(int[] r : t) Arrays.fill(r , -1);

        return solve(prices , 0 , 1);
    }
}