class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] visited = new int[m][n];
        int total = m * n;
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
            for(int j = c - 1 ; j >= 0 ; j--){
                if(visited[r][j] == 2 || visited[r][j] == 3) break;
                if(visited[r][j] == 0){
                    visited[r][j] = 1;
                    total--;
                }
            }
            //for right
            for(int j = c + 1 ; j < n ; j++){
                if(visited[r][j] == 2 || visited[r][j] == 3) break;
                if(visited[r][j] == 0){
                    visited[r][j] = 1;
                    total--;
                }
            }
            //for down
            for(int j = r + 1 ; j < m ; j++){
                if(visited[j][c] == 2 || visited[j][c] == 3) break;
                if(visited[j][c] == 0){
                    visited[j][c] = 1;
                    total--;
                }
            }
            //for up
            for(int j = r - 1 ; j >= 0 ; j--){
                if(visited[j][c] == 2 || visited[j][c] == 3) break;
                if(visited[j][c] == 0){
                    visited[j][c] = 1;
                    total--;
                }
            }
        }

        return total;
    }
}