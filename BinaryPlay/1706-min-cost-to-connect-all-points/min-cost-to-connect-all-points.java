class Solution {
    int[] rank;
    int[] parent;
    public int find(int u){
        if(u == parent[u]) return u;

        return parent[u] = find(parent[u]);
    }
    public void union(int u , int v){
        int u_parent = find(u);
        int v_parent = find(v);

        if(u_parent == v_parent) return;

        if(rank[u_parent] > rank[v_parent]){
            parent[v_parent] = u_parent;
        }else if(rank[u_parent] < rank[v_parent]){
            parent[u_parent] = v_parent;
        }else{
            parent[v_parent] = u_parent;
            rank[u_parent]++;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        //using kruskal algo
        int n = points.length;
        List<int[]> adj = new ArrayList<>();
         
        for(int u = 0 ; u < n ; u++){
            for(int v = u + 1 ; v < n ; v++){
                int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                adj.add(new int[]{u , v , dist}); 
                adj.add(new int[]{v , u , dist}); 
            }
        }

        Collections.sort(adj , new Comparator<int[]>(){
            public int compare(int[] a , int[] b){
                return Integer.compare(a[2] , b[2]);
            }
        });

        parent = new int[n];
        for(int i = 0 ; i < n ;i++) parent[i] = i;

        rank = new int[n];
        int minDist = 0;
        for(int[] v : adj){
            int u_parent = find(v[0]);
            int v_parent = find(v[1]);

            if(u_parent != v_parent){
                union(v[0] , v[1]);
                minDist += v[2];
            } 
        }

        return minDist;
    }
}