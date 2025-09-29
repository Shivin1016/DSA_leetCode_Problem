class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        List<Set<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new HashSet<>());
        }

        for(int[] road : roads){
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }

        int maxNetworkRank = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            int i_rank = adj.get(i).size();
            for(int j = i + 1 ; j < n ; j++){
                int j_rank = adj.get(j).size();
                int totalRank = i_rank + j_rank;
                if(adj.get(i).contains(j)){
                    //connected hai to edge ek count hogi
                    totalRank -= 1;
                }
                maxNetworkRank = Math.max(maxNetworkRank , totalRank);
            }
        }

        return maxNetworkRank;
    }
}