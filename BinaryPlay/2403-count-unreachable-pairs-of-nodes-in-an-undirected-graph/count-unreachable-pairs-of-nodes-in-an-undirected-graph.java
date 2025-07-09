class Solution {
    int[] parent;
    int[] rank;

    int count = 0;
    public void DFS(List<List<Integer>> adj , int u , boolean[] visited){
        if(visited[u] == true){
            return ;
        }
        visited[u] = true; 
        count++;
        for(int v : adj.get(u)){
            if(!visited[v]){
                DFS(adj , v , visited); 
            }
        } 
    }
    public long countPairs(int n, int[][] edges) { 

        //using DFS
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
        List<Integer> componentNodes = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){ 
                count = 0 ;
                DFS(adj , i , visited);
                componentNodes.add(count);
            }
        }

        long unreachablePair = 0;
        long totalNode = n;
        for(int nodes : componentNodes){ 
            //remaingNodes by which pairs are formed
            long remainingNode = totalNode - nodes;
            unreachablePair += (nodes * remainingNode);
            //remove current component nodes
            totalNode -= nodes;
        } 

        return unreachablePair;

        

        // Using DSU 
        /*
        parent = new int[n];
        rank = new int[n]; 

        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){

            int u = edge[0];
            int v = edge[1];

            int parent_u = find(u);
            int parent_v = find(v);
            //make components --> if parent not same then make union
            if(parent_u != parent_v){
                union(u , v);
            }  
        }

        long totalNode = n;
        //stores component size
        Map<Integer , Integer> mp = new HashMap<>();
        for(int u = 0 ; u < n ; u++){  
            int parent = find(u);
            mp.put(parent , mp.getOrDefault(parent , 0) + 1);
        }

        long unreachablePair = 0;
        for(int val : mp.values()){
            //remaingNodes by which pairs are formed
            long remainingNode = totalNode - val;
            unreachablePair += (val * remainingNode);
            //remove current component nodes
            totalNode -= val;
        } 

        return unreachablePair;
        */
    }

    public void union(int u , int v){
        int parent_u = find(u);
        int parent_v = find(v);

        if(parent_u == parent_v){
            return;
        }

        if(rank[parent_u] > rank[parent_v]){
            parent[parent_v] = parent_u;
        } 
        else if(rank[parent_u] < rank[parent_v]){
            parent[parent_u] = parent_v;
        }
        else{
            //same case --> make any of them and increase rank 
            parent[parent_u] = parent_v;
            rank[parent_v]++;
        }
    }

    public int find(int u){
        if(parent[u] == u){
            return u;
        } 
        return parent[u] = find(parent[u]);
    }
}