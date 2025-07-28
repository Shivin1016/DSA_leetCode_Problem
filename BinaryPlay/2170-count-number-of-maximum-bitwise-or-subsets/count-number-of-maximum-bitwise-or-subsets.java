class Solution {
    int n ;
    int[][] dp;
    public int countMaxOrSubsets(int[] nums) {
        n = nums.length;

        //maximum or of nums is the or of all the elements
        int maxOr = 0;
        for(int num : nums) maxOr |= num;

        dp = new int[n + 1][maxOr + 1];
        for(int i = 0 ; i <= n ; i++) Arrays.fill(dp[i] , -1);

        int currOr = 0;
        return solve(nums , 0 , currOr , maxOr);

    }

    public int solve(int[] nums , int i , int currOr , int maxOr){
        if(i == n){
            if(currOr == maxOr){
                return 1;
            }
            return 0;
        }

        if(dp[i][currOr] != -1) return dp[i][currOr];

        //take
        int take = solve(nums , i + 1 , currOr | nums[i] , maxOr);
        //skip
        int skip = solve(nums , i + 1 , currOr , maxOr);

        return dp[i][currOr] = take + skip;
    }
}