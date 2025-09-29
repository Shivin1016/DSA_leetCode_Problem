class DSU{
    int[] parent;
    int[] rank;

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
    }
    public int find(int u){
        return parent[u] = parent[u] == u ? u : find(parent[u]);
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
            rank[parent_v]++;
        }
    }
}
class Solution { 

    public int kruskals(int[][] edges , int skip , int include , int n , int m){

        int mstWt = 0; 
        DSU dsu = new DSU(n);

        if(include != -1){
            //must include that edge
            int[] edge = edges[include]; 
            dsu.union(edge[0] , edge[1]);
            //add weight
            mstWt += edge[2]; 
        }

        for(int i = 0 ; i < m ; i++){
            //don't take that edge
            if(i == skip) continue; 

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            if(dsu.find(u) != dsu.find(v)){
                dsu.union(u , v);
                //add weight
                mstWt += wt;
            }
        }

        //number of edges is not equal to (n - 1) --> hence not mst
        for(int i = 0 ; i < n ; i++){
            if(dsu.find(i) != dsu.find(0)){
                return Integer.MAX_VALUE; //MST hi nhi ban paya 
            }
        }
        return mstWt;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Map<int[] , Integer> index = new HashMap<>();
        int m = edges.length;

        for(int i = 0 ; i < m ; i++){
            index.put(edges[i] , i);
        }

        //sort the edges on basis of weight
        Arrays.sort(edges , (a , b) -> a[2] - b[2]);

        //find mstWt 
        int mstWt = kruskals(edges , -1 , -1 , n , m); //don't skip any edge or include any particular edge 

        //check for each edge is this critical or pseodo critical
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo_critical = new ArrayList<>();

        for(int i = 0 ;  i < m ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            int idx = index.get(edges[i]);
            
            //skip this edge  
            if(kruskals(edges , i , -1 , n , m) > mstWt){
                //critical edge 
                critical.add(idx);
            }
            else if(kruskals(edges , -1 , i , n , m) == mstWt){
                //by including it the mstWt comes same so , it is pseudo critical edge
                pseudo_critical.add(idx);
            }
        } 

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(critical);
        ans.add(pseudo_critical);

        return ans;
    }
}