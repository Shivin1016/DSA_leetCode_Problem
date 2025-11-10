class Graph {
    List<List<int[]>> adj; 
    int N ;
    public Graph(int n, int[][] edges) { 
        N = n; 
        adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){ 
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2]; 
            adj.get(u).add(new int[]{v , cost});
        }
    }
    
    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    } 
    public int path(int source , int dest){ 
        //store shortest distance from source to all other vertices
        int[] res = new int[N]; 
        Arrays.fill(res , Integer.MAX_VALUE);
        res[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // {cost , v}
        pq.add(new int[]{0 , source});

        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int cost = cell[0];
            int u = cell[1];
            for(int[] p : adj.get(u)){
                int v = p[0];
                int newCost = p[1];

                if(newCost + cost < res[v]){
                    res[v] = newCost + cost;
                    pq.add(new int[]{newCost + cost  , v});
                }

            }
        }
        return res[dest];
    }
    public int shortestPath(int node1, int node2) {
        int dist = path(node1 , node2); 
        return (dist == Integer.MAX_VALUE) ? -1 : dist;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */