class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //make Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] person : dislikes){
            int u = person[0];
            int v = person[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] hate = new int[n + 1];
        Arrays.fill(hate , -1);

        for(int i = 1 ; i <= n ; i++){
            if(hate[i] == -1){
                //mark current person hate 1 so buggle wala 0 hoga
                if(dfs(adj , i , hate , 1) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adj , int u , int[] hate , int ishate){
        hate[u] = ishate;

        for(int v : adj.get(u)){

            if(hate[v] == hate[u]){
                return false;
            }

            if(hate[v] == -1){
                //change ishate from u 
                //adjacent hate must not same
                ishate = 1 - hate[u];

                if(dfs(adj , v , hate , ishate) == false){
                    return false;
                }
            }
        }
        return true;
    }
}