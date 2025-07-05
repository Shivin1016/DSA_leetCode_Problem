class Solution {
    int n ;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        
        //using adjency list
        // List<List<Integer>> adj = new ArrayList<>();

        // for(int i = 0 ; i < n ; i++){
        //     adj.add(new ArrayList<>());
        // }

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = 0 ; j < n ; j++){
        //         if(isConnected[i][j] == 1){
        //             adj.get(i).add(j);
        //             adj.get(j).add(i);
        //         }
        //     }
        // }

        boolean[] visited = new boolean[n];
        int countOfProvinces = 0;

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(isConnected , i , visited);
                countOfProvinces++;
            }
        }

        return countOfProvinces;
    }

    public void dfs(int[][] isConnected , int u , boolean[] visited){
        if(visited[u] == true) return;

        visited[u] = true;

        //without using adjency list
        for(int v = 0 ; v < n ; v++){
            if(!visited[v] && isConnected[u][v] == 1){
                dfs(isConnected , v , visited);
            }
        }

        //using adjency list
        // for(int v : adj.get(u)){
        //     if(!visited[v]){ 
        //         dfs(adj , v , visited);
        //     }
        // }


    }
}