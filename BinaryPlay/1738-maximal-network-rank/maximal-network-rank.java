class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        int[] indegree = new int[n];
        boolean[][] connected = new boolean[n][n];

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];

            indegree[u]++;
            indegree[v]++; 
            connected[u][v] = true;
            connected[v][u] = true;
        }

        int maxNetworkRank = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){

            //ith node rank --> kitni nodes se connected hai ye
            int i_rank = indegree[i];

            for(int j = i + 1 ; j < n ; j++){

                //jth node rank --> kitni nodes se connected hai ye
                int j_rank = indegree[j];

                //dono ki ranks
                int totalRank = i_rank + j_rank;

                if(connected[i][j] == true){
                    //connected hai to edge ek count hogi
                    totalRank -= 1;
                }
                //max rank in whole graph
                maxNetworkRank = Math.max(maxNetworkRank , totalRank);
            }
        }

        return maxNetworkRank;
    }
}