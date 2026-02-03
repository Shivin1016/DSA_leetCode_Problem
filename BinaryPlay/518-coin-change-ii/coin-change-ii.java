class Solution {
    int n ;
    int[][] t; 
    public int solve(int[] coins , int i , int target){
        if(i >= n){
            return (target == 0) ? 1 : 0;
        }

        if(t[i][target] != -1) return t[i][target];

        int notTake = solve(coins , i + 1 , target);
        int take = 0;
        if(coins[i] <= target){
            take = solve(coins , i , target - coins[i]);
        }

        return t[i][target] = notTake + take;
    }
    public int change(int amount, int[] coins) {
        n = coins.length; 

        t = new int[301][5001];
        for(int[] r : t) Arrays.fill(r , -1);

        return solve(coins , 0 , amount);
    }
}