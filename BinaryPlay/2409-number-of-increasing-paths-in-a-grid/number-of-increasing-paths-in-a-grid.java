class Solution {
    int n, m;
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int mod = 1000000007;
    int[][] t;

    public boolean canGo(int i, int j, int m, int n) {
        if (i >= 0 && i < m && j >= 0 && j < n) {
            return true;
        }
        return false;
    }

    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        t = new int[1001][1001];
        for(int i = 0 ; i < 1001 ; i++){
            Arrays.fill(t[i] , -1);
        }
        int total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //we have to find total paths ending at (i , j)
                total = (total + DFS(grid, i, j)) % mod;
            }
        }
        return total % mod;
    }

    public int DFS(int[][] grid, int x , int y) {

        //memoization
        if(t[x][y] != -1) return t[x][y];

        int path = 1; // single element is also consider as strictly increasing 

        for (int[] dir : directions) {
            int x_ = x + dir[0];
            int y_ = y + dir[1];

            if (canGo(x_, y_, m, n) && grid[x][y] > grid[x_][y_]) {
                path = (path + DFS(grid , x_ , y_)) % mod;
            }
        }
        return t[x][y] = path % mod;
    }
}