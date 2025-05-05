class Solution {
    int[] memo ;
    int M = 1000000007;
    public int numTilings(int n) {
        //recusrxive approach
        // memo = new int[1001]; 
        // Arrays.fill(memo , - 1);
        // return solve(n);

        //bottom up approach
        if(n == 1 || n == 2) return n;  

        int[] dp = new int[1001];
 
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for(int i = 4 ; i <= n ; i++){
            dp[i] = ((2 * dp[i - 1]) % M + (dp[i - 3]) % M) % M;
        }
        return dp[n];
 

    }
    public int solve(int n ){
        if(n == 1 || n == 2) return n;


        if(memo[n] != -1) return memo[n];

        if(n == 3) return 5;

        return memo[n] = ((2 * solve(n - 1) % M) + (solve(n - 3) % M)) % M;
    }
}