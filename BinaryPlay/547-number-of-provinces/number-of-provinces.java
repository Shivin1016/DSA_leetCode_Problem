class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int countOfProvinces = 0;

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(adj , i , visited);
                countOfProvinces++;
            }
        }

        return countOfProvinces;
    }

    public void dfs(List<List<Integer>> adj , int u , boolean[] visited){
        if(visited[u] == true) return;

        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){ 
                dfs(adj , v , visited);
            }
        }


    }
}