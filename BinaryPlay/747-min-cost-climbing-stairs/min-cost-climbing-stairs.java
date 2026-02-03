class Solution {
    private int solve(int[] cost , int i , int n , int[] dp){
        if(i >= n){
            return 0;
        }
        if(dp[i] != -1) return dp[i];

        int left = cost[i] + solve(cost , i + 1 , n , dp);
        int right = cost[i] + solve(cost , i + 2 , n , dp); 

        return dp[i] = Math.min(left , right);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);

        return Math.min(solve(cost , 0 , n , dp) , solve(cost , 1 , n , dp));
    }
}