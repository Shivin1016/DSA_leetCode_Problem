class Solution {
    long[][] memo;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length; 

        //Recursion + memo
        // memo = new long[n + 1][2]; 
        // for(int i = 0 ; i <= n ; i++){
        //     memo[i][0] = -1;
        //     memo[i][1] = -1;

        // } 
        // return solve(nums , 0 , 1 , n); // Here one show isEven value -> as first index is even

        //Bottom UP apporach->
        long[][] dp = new long[n + 1][2]; 

        for(int i = 1 ; i <= n ; i++){

            //if even Subsequence formed 
            dp[i][0] = Math.max(dp[i - 1][1] - nums[i - 1] , dp[i - 1][0]); 

            //if odd Subsequence formed 
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i - 1] , dp[i - 1][1]); 

        }

        return Math.max(dp[n][0] , dp[n][1]);






    }

    public long solve(int[] nums , int idx , int isEven , int n){

        if(idx >= n) return 0;

        if(memo[idx][isEven] != -1) return memo[idx][isEven];

        //if we skip the index then the operation will be same , if it is plus then add or minus
        long skip = solve(nums , idx + 1 , isEven , n); // send isEven as it is 

        int val = nums[idx];

        val = (isEven == 1) ? val : -val;

        //if we take then operation is changed
        long take = solve(nums , idx + 1 , 1 - isEven , n) + val;

        return memo[idx][isEven] = Math.max(take , skip);

    }
}