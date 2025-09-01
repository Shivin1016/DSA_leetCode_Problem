class Solution {
    int m , n ;
    int[][] t ;

    public int solve(int i , int j , int[][] grid){
        if(i >= m || j >= n || grid[i][j] == 1){
            return 0;
        }

        if(t[i][j] != -1) return t[i][j];

        if(i == m - 1 && j == n - 1){
            return t[i][j] = 1;
        }

        return t[i][j] = solve(i , j + 1 , grid) + solve(i + 1 , j , grid); 

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        t = new int[m + 1][n + 1];
        for(int[] r : t) Arrays.fill(r , -1);

        return solve(0 , 0 , obstacleGrid);
    }
}