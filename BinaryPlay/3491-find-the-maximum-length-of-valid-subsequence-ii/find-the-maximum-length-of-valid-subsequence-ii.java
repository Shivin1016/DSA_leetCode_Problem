class Solution {
    public int maximumLength(int[] nums, int k) {

        int n = nums.length;

        //Initilise dp
        int[][] dp = new int[n][k];

        // dp[i][mod] --> longest valid subsequence ending at index i with modulus mod
        //starting all of zero

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                int mod = (nums[i] + nums[j]) % k;
                dp[i][mod] = Math.max(dp[i][mod] , dp[j][mod] + 1);
                ans = Math.max(ans , dp[i][mod]);
            }
        }

        return ans + 1;
    }
}