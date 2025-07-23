class Solution {
    int[][] directions = {{1,1},{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1}};
    public boolean isSafe(int x , int y , int m , int n){
        if(x < m && y < n && x >= 0 && y >= 0){
            return true;
        }
        return false;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0 || n == 0 || grid[0][0] != 0){
            return -1; // we can't go if src is visited
        }
        //using BFS
        var que = new LinkedList<int[]>();
        que.add(new int[]{0,0}); //add src
        //marked cell(0,0) as visited
        grid[0][0] = 1; 
        int countLevel = 0;

        while(!que.isEmpty()){
            //for level
            int N = que.size();
            while(N > 0){
                //poll new path  
                int[] path = que.poll();
                int x = path[0];
                int y = path[1];

                if(x == m - 1 && y == n -1){
                    //reach target
                    return countLevel + 1; //for cells count we do plus one
                }
                //find all directions
                for(int[] dir : directions){
                    int x_new = x + dir[0];
                    int y_new = y + dir[1];

                    if(isSafe(x_new , y_new , m , n) && grid[x_new][y_new] == 0){
                        //safe and not visited
                        que.add(new int[]{x_new , y_new});
                        //marks visited
                        grid[x_new][y_new] = 1; 
                    }
                } 
                N--;
            } 
            countLevel++;
        }

        return -1;
    }
}