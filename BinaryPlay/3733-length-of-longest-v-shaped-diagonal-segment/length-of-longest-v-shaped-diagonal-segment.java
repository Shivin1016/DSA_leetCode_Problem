class Solution {
    int m , n;
    int[][] direction = {{1 , 1} , {1 , -1} ,{-1 , -1} , {-1 , 1}};

    public boolean canGo(int i , int j){
        if(i >= 0 && i < m && j >= 0 && j < n){
            return true;
        }
        return false;
    }
    public int dfs(int i , int j , int curr_diagonal , boolean can_turn , int[][] grid , int val){
        //find i , j for current diagonal
        int i_ = i + direction[curr_diagonal][0];
        int j_ = j + direction[curr_diagonal][1];

        //if we can't go in next cell or we don't get value that we want then return 0
        if(!canGo(i_ , j_) || grid[i_][j_] != val){
            return 0;
        }
        int length =0;

        //keep moving on current diagonal (then turn stil the same)
        int keep_moving_curr_diagonal = 1 + dfs(i_ , j_ , curr_diagonal , can_turn , grid , val == 2 ? 0 : 2);
        //update length
        length = Math.max(length , keep_moving_curr_diagonal);

        //if we want to take turn --> then check that can we take turn
        if(!can_turn){
            //change the diagonal to adjacent to it (curr_diagonal + 1) % 4 --> we take modulo for return to 0
            //and change the turn value to ture ->becuase now we can not take turn anyMore
            length = Math.max(length , 1 + dfs(i_ , j_ , (curr_diagonal + 1) % 4 , true , grid , val == 2 ? 0 : 2));
        }

        return length;
    }
    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length; 

        int maxLen  = 0;

        for(int i  = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){ 
                 
                if(grid[i][j] == 1){ 

                    for(int d = 0 ; d < 4 ; d++){  
                        maxLen = Math.max(maxLen , 1 + dfs(i , j , d , false , grid , 2));
                    }  
                }
            }
        }
        return maxLen;
    } 
}