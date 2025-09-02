class Solution {
    int m ,n ;  
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;   

        int[][] t = new int[m][n];

        for(int i = m - 1 ; i >= 0 ; i--){
            for(int j = n - 1 ; j >= 0 ; j--){
                if(i == m - 1 && j == n - 1){
                    if(dungeon[i][j] > 0){
                        t[i][j] = 1;
                    }else{
                        t[i][j] = Math.abs(dungeon[i][j]) + 1;
                    }
                }
                else{
                    int right = (j + 1) >= n ? Integer.MAX_VALUE : t[i][j + 1];
                    int down = (i + 1 ) >= m ? Integer.MAX_VALUE : t[i + 1][j];

                    int res = Math.min(right , down) - dungeon[i][j];
                    t[i][j] = res > 0 ? res : 1;
                }
            }
        }

        return t[0][0]; 
    }


}