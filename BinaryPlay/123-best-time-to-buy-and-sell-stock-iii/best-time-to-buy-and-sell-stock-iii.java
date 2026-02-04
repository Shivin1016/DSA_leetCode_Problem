class Solution {
    int n;
    int[][][] t;
    private int solve(int[] prices , int i , int canBuy , int transactCount){
   
        if(transactCount == 0 || i >= n) return 0;

        if(t[i][canBuy][transactCount] != -1) return t[i][canBuy][transactCount];
 
        if(canBuy == 1){
            // buy or skip but transactCount still same because transaction is not completed here
            return t[i][canBuy][transactCount] = Math.max(-prices[i] + solve(prices , i + 1 , 0 , transactCount) , solve(prices , i + 1 , 1 ,transactCount));
        } 
        // sell or hold -> if sell then transaction completed
        return t[i][canBuy][transactCount] = Math.max(+prices[i] + solve(prices , i + 1 , 1 , transactCount - 1) , solve(prices , i + 1 , 0 , transactCount)); 
 
    }
    public int maxProfit(int[] prices) {
        n = prices.length;

        t = new int[n + 1][2][3];
        for(int[][] r : t){
            for(int[] s : r) Arrays.fill(s , -1);
        }

        return solve(prices , 0 , 1 , 2);
    }
}