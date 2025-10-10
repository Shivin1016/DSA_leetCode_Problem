class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        if(n == 1 || n == 0) return 0;

        Set<String> visited = new HashSet<>(); //stores {node , mask(in decimal)}

        var que = new LinkedList<int[]>(); // stores {node , mask(in decimal)}
        //add all nodes in quue because we have to check from all nodes

        for(int i = 0 ; i < n ; i++){
            int maskValue = (1 << i);
            que.add(new int[]{i , maskValue});
            visited.add(i + "," + maskValue);
        }

        int path = 0;
        int allVisited = (1 << n) - 1;
        while(!que.isEmpty()){
            int size = que.size(); //current path/level
            path++;
            while(size-- > 0){
                int[] q = que.pop();
                int node = q[0];
                int mask = q[1]; 

                for(int neigh : graph[node]){
                    int nextMask = (1 << neigh) | mask;
                    String key = neigh + "," + nextMask;
                    if(nextMask == allVisited){
                        return path;
                    }
                    if(!visited.contains(key)){
                        que.add(new int[]{neigh , nextMask});
                        visited.add(key);
                    }
                }
            }
        }
        return path;

    }
}