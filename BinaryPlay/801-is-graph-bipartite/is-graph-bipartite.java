class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color , -1);
 
        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(DFS(graph , i , color , 1) == false){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean DFS(int[][] adj , int currNode , int[] color , int currColor){
        color[currNode] = currColor;

        for(int v : adj[currNode]){
            if(color[v] == color[currNode]){
                return false ; //adjacent have same color --> not Bipartite
            }

            if(color[v] == -1){
                int colorOfV = 1 - color[currNode];
                if(DFS(adj , v , color , colorOfV) == false){
                    return false;
                }
            }
        }

        return true;
    }
}