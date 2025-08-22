class Solution {
    int[][][] dp; 
    int mod = 1000000007;
    public int numOfArrays(int n, int m, int k) {
        
        dp = new int[51][51][101];

        for(int i = 0 ; i < 51 ; i++){
            for(int j = 0 ; j < 51; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return solve(0 , 0 , n , m , 0 , k);
    }

    public int solve(int idx , int maxi , int n , int m , int search_cost , int k){

        if(idx == n){

            if(search_cost == k){
                return 1; // one way found to build array
            }
            
            return 0;
        } 
        if(dp[idx][search_cost][maxi] != -1) return dp[idx][search_cost][maxi];

        int ans = 0;
        for(int num = 1 ; num <= m ; num++){
            if(num > maxi){
                //found greater element so search_cost increases
                ans = (ans + solve(idx + 1 , num , n , m , search_cost + 1 , k)) % mod;
            }else{
                ans = (ans + solve(idx + 1 , maxi , n , m , search_cost , k)) % mod;
            }
        }
        return dp[idx][search_cost][maxi] = ans % mod;
    }
}