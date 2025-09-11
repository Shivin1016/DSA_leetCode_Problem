class Solution {
    int n;
    public void dfs(int[] edges , int node , int[] dist , boolean[] visited){

        visited[node] = true;

        int v = edges[node];

        if(v != -1 && !visited[v]){
            dist[v] = 1 + dist[node];
            dfs(edges , v , dist  , visited);
        }

    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;

        int[] dist1 = new int[n];
        Arrays.fill(dist1 , Integer.MAX_VALUE);
        int[] dist2 = new int[n];
        Arrays.fill(dist2 , Integer.MAX_VALUE);

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];

        dist1[node1] = 0; //dist from node1 to node1
        dist2[node2] = 0;  //dist from node2 to node2

        dfs(edges , node1 , dist1 , visited1);
        dfs(edges , node2 , dist2 , visited2);

        int maxDist = Integer.MIN_VALUE;
        int minDist = Integer.MAX_VALUE;
        int minNode = -1;

        for(int i = 0 ; i < n ; i++){

            maxDist = Math.max(dist1[i] , dist2[i]);

            if(maxDist < minDist){
                minDist = maxDist;
                minNode = i;
            }
        }

        return minNode;

    }
}