class Solution {
    int M ,N ;
    int[][] t; 
    public int dfs(int i , int j){

        if(i == M - 1 && j == N - 1){
            return 1;
        }

        if(i >= M || j >= N) return 0;

        if(t[i][j] != -1) return t[i][j];
 
        return t[i][j] = dfs(i + 1 , j) + dfs(i , j + 1);
    }
    public int uniquePaths(int m, int n) {
        M = m;
        N = n; 

        t = new int[101][101];
        for(int[] r : t){
            Arrays.fill(r , -1);
        }

        return dfs(0 , 0); 
    }

    
}