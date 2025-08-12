class Solution { 
    int mod = (int)(1e9 + 7);
    int[][] dp ;
    public int numberOfWays(int n, int x) { 
        dp = new int[301][301];
        for(int i = 1 ; i < 301 ; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(n , 1 , x); 
    }

    public int solve(int n , int num , int x){ 

        if(n == 0){
           return 1;
        } 

        if(n < 0) return 0; 

        int currPower = (int)Math.pow(num , x);
        if(currPower > n) return 0;

        if(dp[n][num] != -1) return dp[n][num];

        //take oprion
        int take = solve(n - currPower , num + 1 , x);

        //skip option
        int skip = solve(n , num + 1 , x);

        return dp[n][num] = (take + skip) % mod;
    }
}