class Solution {
    int size ;
    public void DFS(List<List<Integer>> adj , int u , boolean[] visited){
        if(visited[u] == true) return;

        visited[u] = true;
        size++;
        for(int v : adj.get(u)){
            if(!visited[v]){
                DFS(adj , v , visited);
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            int x1 = bombs[i][0] , y1 = bombs[i][1];
            for(int j = 0 ; j < n ; j++){
                if(i == j) continue;

                double r1 = bombs[i][2];
                int x2 = bombs[j][0] , y2 = bombs[j][1];
                //d squre value
                double d = Math.pow((x1 - x2) , 2) + Math.pow((y1 - y2) , 2);

                if(r1 >= Math.sqrt(d)){
                    adj.get(i).add(j);
                }
            }
        }
        int result = Integer.MIN_VALUE;
         
        for(int i = 0 ; i < n ; i++){
            size = 0;
            boolean[] visited = new boolean[n];
            DFS(adj , i , visited);
            result = Math.max(size , result);
        }

        return result;
    }
}