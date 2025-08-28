class Solution {
    int m , n ;
    int[][] direction = {{0 , 1} , {1 , 0}};
    int[][] t ;
    public boolean canGo(int x , int y , int[][] obstacleGrid){
        if(x < m && x >= 0 && y < n && y >= 0 && obstacleGrid[x][y] != 1){
            return true;
        }
        return false;
    }
    public int dfs(int i , int j , int[][] obstacleGrid){
        if(i == m - 1 && j == n - 1){
            return t[i][j] = 1;
        }
        if(t[i][j] != -1) return t[i][j];

        int path = 0;
        for(int[] dir : direction){
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if(canGo(i_ , j_ , obstacleGrid)){
                path += dfs(i_ , j_ , obstacleGrid);
            }
        }
        return t[i][j] = path;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;

        //first cell already have obstacle then we can't go any where
        if(obstacleGrid[0][0] == 1) return 0; 

        t = new int[m + 1][n + 1];

        for(int[] r : t) Arrays.fill(r , -1);

        int path = 0; 
        path = dfs(0 , 0 , obstacleGrid);

        return path;

    }
}