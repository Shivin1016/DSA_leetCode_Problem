class Solution {
    int n ;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;

        dp = new int[n + 1][n + 1];
        for(int i = 0 ; i < dp.length ; i++) Arrays.fill(dp[i] , -1);

        return solve(nums , 0 , -1); // idx = 0 , prevIdx = -1
    }
    public int solve(int[] nums , int idx , int prevIdx){
        if(idx >= n) return 0;

        if(prevIdx != -1 && dp[idx][prevIdx] != -1) return dp[idx][prevIdx];

        //take
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            take = 1 + solve(nums , idx + 1 , idx);
        }

        int skip = solve(nums , idx + 1 , prevIdx);

        if(prevIdx != -1){
            dp[idx][prevIdx] = Math.max(take , skip);
        }
        return Math.max(take , skip);
    }
}