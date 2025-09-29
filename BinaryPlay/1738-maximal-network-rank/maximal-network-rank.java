class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        List<TreeSet<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new TreeSet<>());
        }

        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }

        int maxNetworkRank = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){

            //ith node rank --> kitni nodes se connected hai ye
            int i_rank = adj.get(i).size();

            for(int j = i + 1 ; j < n ; j++){

                //jth node rank --> kitni nodes se connected hai ye
                int j_rank = adj.get(j).size(); 

                //dono ki ranks
                int totalRank = i_rank + j_rank;

                if(adj.get(i).contains(j)){
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