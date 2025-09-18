class Solution {
    int size = 0;
    public void dfs(List<List<Integer>> adj , int u , boolean[] visited){
        visited[u] = true;
        size++;

        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj , v , visited);
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        long totalNode = n;
        long unreachable  = 0;

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                size = 0;

                dfs(adj , i , visited);

                long numberOfNodes = size;
                unreachable += (numberOfNodes) * (totalNode - numberOfNodes);
                totalNode -= numberOfNodes;
            }
        }
        return unreachable; 
    }
}