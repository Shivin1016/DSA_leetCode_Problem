class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] result = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(result[i] , Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        result[0][0] = 0;
        pq.offer(new int[]{0, 0 , 0}); 

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currTime = curr[0];
            int i = curr[1];
            int j = curr[2];

            if(i == n - 1 && j == m - 1) return currTime;

            for(int[] dir : directions){
                int i_ = i + dir[0];
                int j_ = j + dir[1]; 

                if(i_ >= 0 && i_ < n && j_ >= 0 && j_ < m){
                    int wait = Math.max(moveTime[i_][j_] - currTime, 0);
                    int arrTime = 0;
                    int movementCost = (i_ + j_);
                    if(movementCost % 2 == 0){
                        // even move then add 2
                        arrTime = currTime + wait + 2;
                    }else{
                        //odd move then add 1
                        arrTime = currTime + wait + 1;
                    }
                     

                    if (result[i_][j_] > arrTime) {
                        result[i_][j_] = arrTime;
                        pq.offer(new int[]{arrTime, i_, j_}); 
                    }
                }
            }
        }

        return -1;


    }
}