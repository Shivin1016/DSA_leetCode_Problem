class Solution {
    int m , n;  
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;  

        int[][] t = new int[m][n];
        //t[i][j] == mini path sum to reach (i)[j] from (0 , 0)
        t[0][0] = grid[0][0];

        //fill first column
        for(int i = 1 ; i < m ; i++){
            t[i][0] = grid[i][0] + t[i - 1][0];
        }
        //fill first row
        for(int j = 1 ; j < n ; j++){
            t[0][j] = grid[0][j] + t[0][j - 1];
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){ 
                t[i][j] = grid[i][j] + Math.min(t[i - 1][j] , t[i][j - 1]); 
            }
        }

        return t[m - 1][n - 1];

    }
}