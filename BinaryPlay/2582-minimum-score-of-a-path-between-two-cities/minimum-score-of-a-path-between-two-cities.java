class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] r : roads){
            int u = r[0];
            int v = r[1];
            int dist = r[2];

            adj.get(u).add(new int[]{v , dist});
            adj.get(v).add(new int[]{u , dist});
        }


        var que = new LinkedList<Integer>();
        que.add(1);

        int[] minPath = new int[n + 1];
        Arrays.fill(minPath , Integer.MAX_VALUE);
        int minScore = Integer.MAX_VALUE;

        while(!que.isEmpty()){
            int u = que.pop(); 
            minScore = Math.min(minScore , minPath[u]); 
            for(int[] nodeDist : adj.get(u)){
                int v = nodeDist[0];
                int dist = nodeDist[1];

                if(minPath[v] > dist){
                    minPath[v] = dist;

                    que.add(v);
                }
            }
        }

        return minScore;
    }
}