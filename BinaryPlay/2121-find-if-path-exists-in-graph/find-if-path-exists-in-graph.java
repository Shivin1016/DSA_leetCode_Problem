class Solution {
    int[] parent;
    int[] rank;
    public int find(int u ){
        if(parent[u] == u){
            return u;
        }

        return parent[u] = find(parent[u]);
    }

    public void union(int u , int v){
        int parent_u = find(u);
        int parent_v = find(v);

        if(parent_u == parent_v) return ;

        if(rank[parent_u] > rank[parent_v]){
            parent[parent_v] = parent_u;
        }else if(rank[parent_u] < rank[parent_v]){
            parent[parent_u] = parent_v;
        }else{
            parent[parent_u] = parent_v;
            rank[parent_v]++;
        }

    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        //using DSU
        parent = new int[n];
        for(int i = 0 ; i < n ; i++) parent[i] = i;
        rank = new int[n];

        for(int[] edge : edges){
            union(edge[0] , edge[1]);
        }

        //now check that src and destination have equal parents or not --> if parent's equal then they are in same component else not

        if(find(source) == find(destination)){
            return true;
        }
        return false;

        //using DFS
        /*
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

        //src and destination are not in same component then path can't be exist
        if(visited[source] == false || visited[destination] == false) return false;

        return true;
        */
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