class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        if(n == 1 || n == 0) return 0;

        //take set
        // Set<String> visited = new HashSet<>(); //stores {node , mask(in decimal)}

        int allVisited = (1 << n) - 1;
        //using 2d grid
        boolean[][] visited = new boolean[n][allVisited + 1];

        var que = new LinkedList<int[]>(); // stores {node , mask(in decimal)}
        //add all nodes in quue because we have to check from all nodes

        for(int i = 0 ; i < n ; i++){
            int maskValue = (1 << i);
            que.add(new int[]{i , maskValue});
            // visited.add(i + "," + maskValue);
            visited[i][maskValue] = true;
        }

        int path = 0; 
        while(!que.isEmpty()){
            int size = que.size(); //current path/level
            path++;
            while(size-- > 0){
                int[] q = que.pop();
                int node = q[0];
                int mask = q[1]; 

                for(int neigh : graph[node]){
                    int nextMask = (1 << neigh) | mask; 
                    if(nextMask == allVisited){
                        return path;
                    }
                    if(!visited[neigh][nextMask]){
                        que.add(new int[]{neigh , nextMask});
                        visited[neigh][nextMask] = true;
                    }
                }
            }
        }
        return path;

    }
}