class Solution {
    public void dfs(List<List<int[]>> adj , int node , int minScore , boolean[] visited){
        visited[node] = true;
        for(int[] v : adj.get(node)){
            int u = v[0];
            int dist = v[1];
            minScore = Math.min(minScore , dist);
            if(!visited[u]){
                dfs(adj , u , minScore , visited);
            }
        }
    }
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
 
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];

        //using bfs
        var que = new LinkedList<Integer>();
        que.add(1);
        visited[1] = true;
        while(!que.isEmpty()){

            int u = que.pop();  

            for(int[] nodeDist : adj.get(u)){
                int v = nodeDist[0];
                int dist = nodeDist[1];  
                minScore = Math.min(minScore , dist);
                if(!visited[v]){
                    que.add(v); 
                    visited[v] = true; 
                }
            }
        }
        

        //using dfs 
        // dfs(adj , 1 , minScore , visited); 

        return minScore;
    }
}