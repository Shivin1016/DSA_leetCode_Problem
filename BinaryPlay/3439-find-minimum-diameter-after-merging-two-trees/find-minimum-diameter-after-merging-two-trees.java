class Solution {
    public int[] BFS(List<List<Integer>> adj , int source){
        var que = new LinkedList<Integer>();
        int farthestNode = source;
        int dist = 0;
        que.add(source);

        boolean[] visited = new boolean[adj.size()]; 
        visited[source] = true;

        while(!que.isEmpty()){
            int size = que.size(); // current level me itne nodes hai
            while(size > 0){
                int node = que.poll();
                farthestNode = node;

                for(int v : adj.get(node)){
                    if(!visited[v]){
                        visited[v] = true;
                        que.add(v);
                    }
                }
                size--;
            }
            //increase distance -->level
            if(!que.isEmpty()){
                dist++;
            }
        }

        return new int[]{farthestNode , dist};
    }
    public int findDiameter(List<List<Integer>> adj){
        //step1 => find the farthest node from a random node
        int[] farthestDist = BFS(adj , 0); // send adj , random node
        int farthestNode = farthestDist[0];
        int dist = farthestDist[1];

        //step2 ->  farthest node we got above is nothing but one end of the diameter of adj

        //step3 ->fins the farthest node we got from above , that will be the other end of the diameter
        int[] otherEndDiamter = BFS(adj , farthestNode);

        return otherEndDiamter[1];
    }
    public List<List<Integer>> buildAdjList(int[][] edges){
        int n = edges.length;  
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) { 

        List<List<Integer>> adj1 = buildAdjList(edges1); 
        List<List<Integer>> adj2 = buildAdjList(edges2);
 
        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);
        // diameter from half of both trees and plus connecting edge
        int combined = ((d1 + 1) / 2) + ((d2 + 1) / 2) + 1;

        return Math.max(d1 , Math.max(d2 , combined));

    }
}