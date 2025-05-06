class Solution { 
    int[][][] memo;
    int M = 1000000007;
    public int numOfArrays(int n, int m, int k) {
        //using recursive approach
        // return solve(0 , 0 , -1 , n , m , k); 

        //memoization code
        memo = new int[51][51][101];
        for(int i = 0 ; i < 51 ; i++){
            for(int j = 0 ; j < 51 ; j++){
                Arrays.fill(memo[i][j] , -1);
            }
        }
        
        return solve(0 , 0 , 0 , n , m , k);
    }

    public int solve(int idx , int searchCost , int maxSoFar , int n , int m , int k){
        //base Case
        if(idx == n){
            if(searchCost == k){
                return 1;
            }else{
                return 0;
            }
        }

        if(memo[idx][searchCost][maxSoFar] != -1) return memo[idx][searchCost][maxSoFar];

        //check for every idx 
        int result = 0;
        for(int num = 1 ; num <= m ; num++){
            if(maxSoFar < num){
                result = ((result + solve(idx + 1 , searchCost + 1 , num , n , m , k)) % M);
            }else{
                result = ((result + solve(idx + 1 , searchCost , maxSoFar , n , m , k)) % M);
            }
        }

        return memo[idx][searchCost][maxSoFar] = result % M;


    }
}