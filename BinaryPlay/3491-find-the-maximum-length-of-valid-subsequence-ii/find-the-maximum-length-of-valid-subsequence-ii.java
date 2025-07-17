class Solution {
    public int maximumLength(int[] nums, int k) {

        int n = nums.length;

        //Initilise dp
        int[][] dp = new int[n][k];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , 1);
        }

        // dp[i][mod] --> longest valid subsequence ending at index i with modulus mod
        //starting all of 1

        //total numbers of modulud can be k - 1
        //col = 0 --> % k = 0;
        //col = 1 --> % k = 1
        // ....
        //col = k - 1 --> % k = k - 1;

        int ans = 1;
        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                //find modulus
                int mod = (nums[i] + nums[j]) % k;

                dp[i][mod] = Math.max(dp[i][mod] , dp[j][mod] + 1); 

                ans = Math.max(dp[i][mod] , ans);
            }
        }

        return ans; // for pairs add 1
        
    }
}