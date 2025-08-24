class Solution {

    int m , n ;

    int[][] directions = {{1, 0} , {-1 , 0} , {0 , -1} , {0 , 1}};

    int[][] t;

    public boolean canGo(int i , int j , int m , int n){
        if(i >= 0 && j >= 0 && i < m && j < n){
            return true;
        }
        return false;
    }

    public int DFS(int[][] grid , int i , int j ){
        if(t[i][j] != -1) return t[i][j];
        int len = 1; // single elemnt ek khud me increasing path hota hai 

        for(int[] dir : directions){
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if(canGo(i_ , j_ , m , n) && grid[i][j] < grid[i_][j_]){
                len = Math.max(len , (1 + DFS(grid , i_ , j_))); 
            }
        }
        return t[i][j] = len;
    }
    public int longestIncreasingPath(int[][] matrix) {

        m = matrix.length;
        n = matrix[0].length;

        //memoization
        t = new int[201][201];
        for(int[] row : t) Arrays.fill(row , -1);

        int maxLen = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){ 
                maxLen = Math.max(maxLen , DFS(matrix , i , j));
            }
        }

        return maxLen;
    }
}