class Solution {
    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] connections) {
        //Adjencecy List
        List<List<Integer>> adj = new ArrayList<>();

        //if total edges is not equal to n - 1 return -1
        if(connections.length < (n - 1)) return -1;

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] join : connections){
            int u = join[0];
            int v = join[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        parent = new int[n];
        rank = new int[n];

        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        int component = n;  

        for(int u = 0 ; u < n ; u++){ 
            for(int v : adj.get(u)){
                if(u < v){
                    int parent_u = find(u);
                    int parent_v = find(v);

                    //connection have more than one cables so break it
                    if(parent_u != parent_v){
                        //not connect then connect
                        union(u , v);
                        component--;
                    } 
                }
            }
        } 

        return component - 1;
    }

    public void union(int u , int v){
        int parent_u = find(u);
        int parent_v = find(v);

        if(parent_u == parent_v){
            return ;
        }

        if(rank[parent_u] > rank[parent_v]){
            parent[parent_v] = parent_u;
        }
        else if(rank[parent_u] < rank[parent_v]){
            parent[parent_u] = parent_v;
        }
        else{
            parent[parent_u] = parent_v;
            rank[parent_v] += 1;
        }
    }

    public int find(int u){
        if(parent[u] == u){
            return u;
        }

        return parent[u] = find(parent[u]);
    }
}