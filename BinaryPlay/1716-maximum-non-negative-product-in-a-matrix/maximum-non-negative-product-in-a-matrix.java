class Solution {
    int m , n ;
    long mod = 1000000007;
    Pair<Long , Long>[][] t;
    public Pair<Long , Long> solve(int i , int j , int[][] grid){

        if(i == m - 1 && j == n - 1) return t[i][j] = new Pair<>((long)grid[i][j] , (long)grid[i][j]);

        if(t[i][j] != null) return t[i][j];

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if(i + 1 < m){
            Pair<Long , Long> down = solve(i + 1 , j , grid);

            maxVal = Math.max(maxVal , Math.max(grid[i][j] * down.getKey() , grid[i][j] * down.getValue()));
            minVal = Math.min(minVal , Math.min(grid[i][j] * down.getKey() , grid[i][j] * down.getValue()));

        }

        if(j + 1 < n){
            Pair<Long , Long> right = solve(i , j + 1, grid);

            maxVal = Math.max(maxVal , Math.max(grid[i][j] * right.getKey() , grid[i][j] * right.getValue()));
            minVal = Math.min(minVal , Math.min(grid[i][j] * right.getKey() , grid[i][j] * right.getValue()));
        }

        return t[i][j] = new Pair<>(maxVal , minVal);
    }
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        t = new Pair[m][n];

        Pair<Long ,Long> ans = solve(0 , 0 , grid);  

        return ans.getKey() < 0 ? -1 : (int)(ans.getKey() % mod) ;
    }
}