class Solution {
    int[][] t;
    public int solve(int i , int j , int m , int n){
        if(i >= m || j >= n){
            return 0;
        }

        if(t[i][j] != -1) return t[i][j];

        if(i == m - 1&& j == n - 1){
            return 1;
        }

        return t[i][j] = solve(i , j + 1 , m , n) + solve(i + 1 , j , m , n);

    }
    public int uniquePaths(int m, int n) {

        t = new int[m + 1][n + 1];
        for(int[] r : t) Arrays.fill(r , -1);

        return solve(0 , 0 , m , n);
    }
}