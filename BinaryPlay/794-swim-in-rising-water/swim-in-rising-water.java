class Solution {
    int[][] direction = {{1 , 0} , {0 , 1} , {-1 , 0} ,{0 ,-1}};
    public int swimInWater(int[][] grid) {
        // using dijekstra

        int n = grid.length;

        var pq = new PriorityQueue<int[]>((a , b) -> a[0] - b[0]);
        pq.add(new int[]{grid[0][0] , 0 , 0});

        int[][] res = new int[n][n];
        for(int[] r : res) Arrays.fill(r , Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] info = pq.poll();
            int currentTime = info[0];
            int x = info[1];
            int y = info[2];

            if(x == n - 1 && y == n - 1){
                return currentTime;
            }

            for(int[] dir : direction){
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if(x_ >= 0 && y_ >= 0 && x_ < n && y_ < n){
                    int nextTime = Math.max(currentTime , grid[x_][y_]);
                    if(nextTime < res[x_][y_]){
                        res[x_][y_] = nextTime;
                        pq.add(new int[]{nextTime , x_ , y_});
                    }
                }
            }
        }

        return res[n - 1][n - 1];
        
    }
}