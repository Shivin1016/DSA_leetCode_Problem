class Solution {
    int[][] directions = {{1 , 0} , {-1 , 0} , {0 , 1} , {0 , -1}};

    public boolean canGo(int x , int y , int m , int n , char[][] maze){
        if(x < m && x >= 0 && y < n && y >= 0 && maze[x][y] == '.'){
            return true;
        }
        return false;
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length; 

        var que = new LinkedList<int[]>();
        que.add(entrance);

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
 
        int level = 0;

        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){

                int[] cell = que.poll();

                int x = cell[0];
                int y = cell[1]; 

                //we found an exitDoor return level -> becuase BFS gives minimum step  
                if((x == 0 || y == 0 || x == m - 1 || y == n - 1) && !(x == entrance[0] && y == entrance[1])){
                    return level;
                } 
                //explore kro
                for(int[] dir : directions){
                    int x_ = x + dir[0];
                    int y_ = y + dir[1]; 

                    if(canGo(x_ , y_ , m , n , maze) && !visited[x_][y_]){
                        visited[x_][y_] = true;
                        que.add(new int[]{x_ , y_});
                    }
                } 

            }
            level++;
        }

        return -1;
    }
}