class Solution {
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    private boolean isSafe(int x , int y , int m , int n){
        return x < m && y < n && x >= 0 && y >= 0;
    }
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length; 

        //using dijkstra
        //why dijkstra --> because there is src to destination reach with minimum
        //and weighted edge --> absDiff
        int[][] result = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(result[i] , Integer.MAX_VALUE);
        }
        var pq = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0,0,0}); //src to src => absDiff = 0 
        result[0][0] = 0;

        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int diff = p[0];
            int x = p[1];
            int y = p[2];

            for(int[] dir : direction){
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if(isSafe(x_ , y_ , m, n)){
                    int absDiff = Math.abs(heights[x_][y_] - heights[x][y]);
                    absDiff = Math.max(diff , absDiff); 
                    //we get max diff in the current path then check for result
                    if(absDiff < result[x_][y_]){
                        //add in pq
                        pq.add(new int[]{absDiff , x_ , y_});
                        result[x_][y_] = absDiff;
                    } 
                }
            }
        }

        return result[m - 1][n - 1];
    }
}