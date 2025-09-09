class Solution {
    int[] parent;
    int[] rank;
    public int find(int u){
        if(u == parent[u]) return u;

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
            //same rank make any one of them to parent ans increase the rank
            parent[parent_u] = parent_v;
            rank[parent_v]++;
        }
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;

        parent = new int[n];
        for(int i =0 ; i < n ; i++) parent[i] = i;
        rank  = new int[n];
        //make adj
        Map<Integer , List<Integer>> adj = new HashMap<>();
        TreeMap<Integer , List<Integer>> valNodes = new TreeMap<>(); // val --> {nodes}

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u , k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v , k -> new ArrayList<>()).add(u); 
        }

        for(int i = 0 ; i < n ; i++){
            int value = vals[i];
            //stores all nodes which have same value of 'val'   
            valNodes.computeIfAbsent(value , k -> new ArrayList<>()).add(i);
        }

        int result = n ; // all single nodes itself an good path
        boolean[] isActive = new boolean[n] ; // all noed are inActive

        for(int val : valNodes.keySet()){
            //all nodes which have value val
            List<Integer> nodes = valNodes.get(val);
            for(int u : nodes){
                for(int v : adj.getOrDefault(u , new ArrayList<>())){
                    if(isActive[v]){
                        //make union with node
                        union(u , v);
                    }
                }
                //active u also
                isActive[u] = true;
            }
            //u nodes ke parents
            List<Integer> tmre_parents = new ArrayList<>();
            for(int u : nodes){
                tmre_parents.add(find(u));
            }

            //check which parents are same
            Collections.sort(tmre_parents);
            for(int i = 0 ; i < tmre_parents.size() ; i++){
                int count = 0;
                int curr_parent = tmre_parents.get(i);
                while(i < tmre_parents.size() && curr_parent == tmre_parents.get(i)){
                    count++;
                    i++;
                }
                i--;

                int formula = (count * (count - 1)) / 2;
                result += formula;
            }
        }
        return result;

    }
}