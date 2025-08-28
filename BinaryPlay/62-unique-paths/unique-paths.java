class Solution {
    int M ,N ;
    int[][] t;
    int[][] direction = {{0 , 1}, {1 , 0}};
    public int dfs(int i , int j){

        if(i == M - 1 && j == N - 1){
            return 1;
        }

        if(t[i][j] != -1) return t[i][j];

        int path = 0;
        for(int[] dir : direction){
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if(i_ < M && j_ < N){
                path += dfs(i_ , j_);
            }
        }
        return t[i][j] = path;
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