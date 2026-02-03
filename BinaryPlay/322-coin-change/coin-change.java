class Solution {
    int n ;
    int[][] t;

    public int solve(int[] coins , int i , int sum){
        if(sum == 0) return 0;
        if(i >= n){
            return (int)1e9;
        }
        
        if(t[i][sum] != -1) return t[i][sum];
        
        int notTake = solve(coins , i + 1 , sum);
        int take = (int)1e9;
        if(coins[i] <= sum){
            take = 1 + solve(coins , i , sum - coins[i]);
        }
        
        return t[i][sum] = Math.min(take , notTake);
    }
    public int coinChange(int[] coins, int amount) {
        n = coins.length;

        t = new int[13][10001];
        for(int[] r : t) Arrays.fill(r , -1);
        int ans = solve(coins , 0 , amount);
        return ans == (int)1e9 ? -1 : ans;
    }
}