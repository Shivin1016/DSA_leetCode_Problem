class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color , -1);


        //Using DFS
        // for(int i = 0 ; i < n ; i++){
        //     if(color[i] == -1){
        //         if(DFS(graph , i , color , 1) == false){
        //             return false;
        //         }
        //     }
        // }
        // return true;

        //using BFS 
        for(int i = 0 ; i < n ; i++){
            if(color[i] == -1){
                if(BFS(graph , i , color , 1) == false){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean BFS(int[][] adj , int node , int[] color , int currColor){
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);
        //color the node
        color[node] = currColor;

        while(!que.isEmpty()){

            int u = que.poll();

            for(int v : adj[u]){
                //same color matched
                if(color[v] == color[u]){
                    return false;
                }

                if(color[v] == -1){
                    //color thr node
                    color[v] = 1 - color[u];
                    que.offer(v);
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