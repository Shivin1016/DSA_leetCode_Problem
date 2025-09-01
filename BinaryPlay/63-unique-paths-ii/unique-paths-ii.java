class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            //row filling -> if we got an obstacles on moving down then break
            if (obstacleGrid[i][0] == 1) {
                break;
            }

            t[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            //row filling -> if we got an obstacles on moving down then break
            if (obstacleGrid[0][j] == 1)
                break;

            t[0][j] = 1;
        }

        for (int i = 1 ; i < m ; i++) {
            for (int j = 1 ; j < n ; j++) {
                if (obstacleGrid[i][j] == 1) {
                    //we can't reach this cell by from any direction
                    continue;
                }

                t[i][j] = t[i - 1][j] + t[i][j - 1];
            }
        }

        return t[m - 1][n - 1];
    }
}