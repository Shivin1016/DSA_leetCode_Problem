class Solution {
    public int uniquePaths(int m, int n) {

        //botttom approach
        int[][] t = new int[m + 1][n + 1];
        // t[i][j] --> totla number of ways to reach (i , j) from (0 , 0)

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 1;
                }
                else{
                    t[i][j] = t[i - 1][j] + t[i][j - 1];
                }
            }
        }

        return t[m - 1][n - 1];
    }
}