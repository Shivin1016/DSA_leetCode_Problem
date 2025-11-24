class Solution {
    int n ;
    int[][] dp;
    public int solve(int i , int rem , int[] nums){
        if(i >= n){
            if(rem == 0) return 0;
            else return Integer.MIN_VALUE; 
        }
        if(dp[i][rem] != -1) return dp[i][rem];

        int take = nums[i] + solve(i + 1 , (rem + nums[i]) % 3 , nums);
        int skip = solve(i + 1 , rem , nums);

        return dp[i][rem] = Math.max(take , skip);
    }
    public int maxSumDivThree(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][3];
        for(int[] r : dp) Arrays.fill(r , -1);
        
        // Dynamic Programming approach 
        return solve(0 , 0 , nums);
    }
}