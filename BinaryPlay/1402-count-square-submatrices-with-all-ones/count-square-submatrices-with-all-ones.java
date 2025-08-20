class Solution {
    int m , n;
    int[][] dp;
    public int countSquares(int[][] matrix) {

        m = matrix.length;
        n = matrix[0].length;

        int res = 0;
        dp = new int[m + 1][n + 1];
        for(int i = 0 ; i <= m ; i++) Arrays.fill(dp[i] , -1);

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){  
                //agr cell me one hai tabhi recusrion maro
                if(matrix[i][j] == 1){
                    res += solve(i , j , matrix);
                }
            }
        }

        return res;
    }
    public int solve(int i , int j , int[][] matrix){

        if(i >= m || j >= n) return 0;

        if(matrix[i][j] == 0){
            return 0; // is cell se possible hi nhi hai
        }

        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(i , j + 1 , matrix);
        int diagonally = solve(i + 1 , j + 1 , matrix);
        int below = solve(i + 1 , j , matrix);

        return dp[i][j] = 1 + Math.min(right , Math.min(diagonally , below));

    }
}