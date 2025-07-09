class Solution {
    int[] parent;
    int[] rank;
    public long countPairs(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];

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

        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }

        for(int u = 0 ; u < n ; u++){
            for(int v : adj.get(u)){
                if(u < v){
                    int parent_u = find(u);
                    int parent_v = find(v);

                    if(parent_u != parent_v){
                        union(u , v);
                    }
                }
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
            unreachablePair += (val * (totalNode - val));
            totalNode -= val;
        } 

        return unreachablePair;
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