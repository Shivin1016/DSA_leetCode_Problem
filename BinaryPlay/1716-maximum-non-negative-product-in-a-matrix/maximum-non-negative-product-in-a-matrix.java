class Solution {
    int m , n ;
    long mod = 1000000007; 
    
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Pair<Long , Long>[][] t = new Pair[m][n];

        //for (0 , 0) --> there is max = gris[0][0] , min = grid[0][0]
        t[0][0] = new Pair<>((long)grid[0][0] , (long)grid[0][0]);

        //first col--> fill with simple multiply grid val by previous up side max, min val
        for(int i = 1 ; i < m ; i++){
            Pair<Long , Long> p = t[i - 1][0];
            long maxVal = grid[i][0]  * p.getKey();
            long minVal = grid[i][0] * p.getValue();
            t[i][0] = new Pair<>(maxVal , minVal);
        }

        //first row--> fill with simple multiply grid val by previous left side max, min val
        for(int j = 1 ; j < n ; j++){
            Pair<Long , Long> p = t[0][j - 1];
            long maxVal = grid[0][j]  * p.getKey();
            long minVal = grid[0][j] * p.getValue();
            t[0][j] = new Pair<>(maxVal , minVal);
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){

                long maxVal = Long.MIN_VALUE;
                long minVal = Long.MAX_VALUE;

                //left side to right side
                Pair<Long , Long> p = t[i][j - 1];
                maxVal = Math.max(maxVal , Math.max(grid[i][j]  * p.getKey() , grid[i][j]  * p.getValue()));
                minVal = Math.min(minVal , Math.min(grid[i][j]  * p.getKey() , grid[i][j]  * p.getValue()));

                //left top to down side
                p = t[i - 1][j];
                maxVal = Math.max(maxVal , Math.max(grid[i][j]  * p.getKey() , grid[i][j]  * p.getValue()));
                minVal = Math.min(minVal , Math.min(grid[i][j]  * p.getKey() , grid[i][j]  * p.getValue()));

                t[i][j] = new Pair<>(maxVal , minVal);
            }
        }

        Pair<Long ,Long> ans = t[m - 1][n - 1];  

        return ans.getKey() < 0 ? -1 : (int)(ans.getKey() % mod) ;
    }
}