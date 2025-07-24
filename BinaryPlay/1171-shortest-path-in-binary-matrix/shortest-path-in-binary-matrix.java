class Solution {
    int[][] directions = {{1,1},{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1}};
    int n, m;

    public boolean isSafe(int x, int y) {
        return (x < m && y < n && x >= 0 && y >= 0);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        if (m == 0 || n == 0 || grid[0][0] != 0)
            return -1; //we can't go if src is already visited marked

        //make 2d result to store each cell dist 
        int[][] result = new int[m][n];

        //fill it with maxValues in starting all have maxdist
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); //min heap of array of (dist ,x , y)
        pq.offer(new int[] { 0, 0, 0 }); //src se src ki duri is 0 --> min dist so add in pq

        //add in result of 2d matrix
        result[0][0] = 0; 

        //mark visited grid
        grid[0][0] = 1;

        while (!pq.isEmpty()) {
            //poll new cell and dist
            int[] p = pq.poll();

            int d = p[0]; //give distance 
            //gives coordinates of cell
            int x = p[1];
            int y = p[2];
            //check for all directions
            for (int[] dir : directions) {
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                //find dist 
                int minDist = d + 1;
                //check for safe and grid visited
                if (isSafe(new_x, new_y) && grid[new_x][new_y] == 0 && minDist < result[new_x][new_y]) {
                    //find another minimum path from cell(x,y) to cell(new_x , new_y)
                    //update in pq
                    pq.offer(new int[] { minDist, new_x, new_y });

                    //update result
                    result[new_x][new_y] = minDist; 

                    //mark visited
                    grid[new_x][new_y] = 1;

                }
            }
        }

        //if we cant reach destination then return -1
        return result[m - 1][n - 1] != Integer.MAX_VALUE ? result[m - 1][n - 1] + 1 : -1;
    }
}