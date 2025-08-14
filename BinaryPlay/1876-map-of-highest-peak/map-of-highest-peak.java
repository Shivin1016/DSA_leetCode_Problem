class Solution {
    int[][] directions = {{-1 , 0} , {1 , 0} , {0 , -1} , {0 , 1}};
    public boolean canFill(int x , int y , int m , int n , int[][] height){
        if(x >= 0 && x < m && y < n && y >= 0 && height[x][y] == -1){
            return true;
        }
        return false;
    }
    public int[][] highestPeak(int[][] isWater) {

        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        var que = new LinkedList<int[]>();

        for(int i = 0 ; i < m ; i++){

            for(int j = 0 ; j < n ; j++){

                // water cell it is already 0 and put into que
                if(isWater[i][j] == 1){
                    que.offer(new int[]{i , j , 0});
                }
                else{
                    //inititally land cell fill with height = -1
                    height[i][j] = -1;
                }
            }
        }

        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int[] cell = que.poll();
                int i = cell[0];
                int j = cell[1];
                int currHeight = cell[2];

                for(int[] dir : directions){
                    //current coords
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if(canFill(new_i , new_j , m , n , height)){
                        // filled it currHeight + 1 because to ensure absDiff <= 1 
                        height[new_i][new_j] = currHeight + 1;
                        que.offer(new int[]{new_i , new_j , currHeight + 1});
                    }
                }
            }
        }

        return height;




    }
}