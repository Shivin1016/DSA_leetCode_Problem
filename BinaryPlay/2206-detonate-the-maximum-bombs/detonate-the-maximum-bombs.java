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

    public void BFS(List<List<Integer>> adj , int u , boolean[] visited){
        var que = new LinkedList<Integer>();
        que.add(u);
        visited[u] = true;
        while(!que.isEmpty()){
            int bomb = que.pop();
            size++;
            for(int v : adj.get(bomb)){
                if(!visited[v]){
                    que.add(v);
                    visited[v] = true;
                }
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            // bomb1 coordinates
            int x1 = bombs[i][0] , y1 = bombs[i][1];

            for(int j = 0 ; j < n ; j++){

                if(i == j) continue;

                //bomb1 ilaka
                double r1 = bombs[i][2];

                // bomb2 coordinates
                int x2 = bombs[j][0] , y2 = bombs[j][1];
                //d squre value
                double d = Math.pow((x1 - x2) , 2) + Math.pow((y1 - y2) , 2);

                //check is bomb2 can lies inside bomb1
                if(r1 >= Math.sqrt(d)){
                    adj.get(i).add(j);
                }
            }
        }
        int result = Integer.MIN_VALUE;
         
        for(int i = 0 ; i < n ; i++){
            size = 0;
            boolean[] visited = new boolean[n];
            // count how many bombs can be detonated by ith bomb
            // DFS(adj , i , visited);
            BFS(adj , i , visited);
            result = Math.max(size , result);
        }

        return result;
    }
}