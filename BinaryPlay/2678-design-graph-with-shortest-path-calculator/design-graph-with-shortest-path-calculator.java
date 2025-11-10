class Graph {
    List<List<int[]>> adj; 
    int[][] grid;
    int N ;
    public Graph(int n, int[][] edges) { 
        N = n; 
        grid = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(grid[i] , (int)1e9);
            grid[i][i] = 0;
        }  

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2]; 
            grid[u][v] = cost;
        }
        
        // using floyd warshell algo 
        //store MultiSource shortest distance from all vertex to all other vertices
        for(int vertex = 0 ; vertex < n ; vertex++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    grid[i][j] = Math.min(grid[i][j] , grid[i][vertex] + grid[vertex][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];  
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                grid[i][j] = Math.min(grid[i][j] , grid[i][u] + cost + grid[v][j]);
            }
        }
    } 
    // using dijkstra algo
    // public int path1(int source , int dest){ 
    //     //store shortest distance from source to all other vertices
    //     int[] res = new int[N]; 
    //     Arrays.fill(res , Integer.MAX_VALUE);
    //     res[source] = 0;

    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // {cost , v}
    //     pq.add(new int[]{0 , source});

    //     while(!pq.isEmpty()){
    //         int[] cell = pq.poll();
    //         int cost = cell[0];
    //         int u = cell[1];
    //         for(int[] p : adj.get(u)){
    //             int v = p[0];
    //             int newCost = p[1];

    //             if(newCost + cost < res[v]){
    //                 res[v] = newCost + cost;
    //                 pq.add(new int[]{newCost + cost  , v});
    //             }

    //         }
    //     }
    //     return res[dest];
    // } 
    public int shortestPath(int node1, int node2) {
        // int dist = path1(node1 , node2);  //using dijkestra 
        int dist = grid[node1][node2]; // using floyd warshell algo 
        return (dist == (int)1e9) ? -1 : dist;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */