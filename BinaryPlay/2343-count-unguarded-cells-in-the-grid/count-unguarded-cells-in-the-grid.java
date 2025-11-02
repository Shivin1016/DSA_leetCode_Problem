class Solution {
    int total , N , M;
    int[][] visited ;
    public void dfs(int i , int j , String dir){
        if(i < 0 || i >= M || j < 0 || j >= N) return;

        if(visited[i][j] == 2 || visited[i][j] == 3 ) return;

        if(visited[i][j] == 0){
            visited[i][j] = 1;
            total--;  
        }
        if(dir.equals("left")){
            dfs(i , j - 1 , dir);
        }else if(dir.equals("right")){
            dfs(i , j + 1 , dir);
        }else if(dir.equals("down")){
            dfs(i + 1 , j , dir);
        }else if(dir.equals("up")){
            dfs(i - 1 , j , dir);
        } 
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        N = n ;
        M = m ;
        visited = new int[m][n];
        total = m * n;
        //guards --> 3
        for(int i = 0 ; i < guards.length ; i++){
            visited[guards[i][0]][guards[i][1]] = 3;
            total--;
        }
        //walls --> 2
        for(int i = 0 ; i < walls.length ; i++){
            visited[walls[i][0]][walls[i][1]] = 2;
            total--;
        }

        for(int i = 0 ; i < guards.length ; i++){
            int r = guards[i][0] ;
            int c = guards[i][1];

            //for left
            dfs(r , c - 1 , "left"); 
            //for right
            dfs(r , c + 1 , "right");
            //for down
            dfs(r + 1 , c , "down");
            //for up
            dfs(r - 1 , c , "up");
        }

        return total;
    }
}