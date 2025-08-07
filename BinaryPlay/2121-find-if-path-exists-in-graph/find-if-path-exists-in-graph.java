class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // ..make adjency list
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

        //check that src and destination vertices must be connected in a single component
        boolean[] visited = new boolean[n];
        DFS(adj , source , visited);

        if(visited[source] == false || visited[destination] == false) return false;

        return true;
    }
    public void DFS(List<List<Integer>> adj , int u , boolean[] visited){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){
                DFS(adj , v , visited);
            }
        }
    }
}