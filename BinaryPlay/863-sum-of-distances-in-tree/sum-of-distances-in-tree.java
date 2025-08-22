class Solution { 
    int root_result = 0;
    int[] count ; //stores the count of children of child including it
    int N ; //total number of nodes

    public int dfs_root(List<List<Integer>> adj , int parentNode , int prevNode , int dist){
        
        int total_count = 1;

        root_result += dist;

        for(int child : adj.get(parentNode)){
            if(child == prevNode){
                continue; // vapis se parent pe a gaye 
            }
            total_count += dfs_root(adj , child , parentNode , dist + 1);
        }
        count[parentNode]  = total_count;

        return total_count;
    }
    public void DFS(List<List<Integer>> adj , int parentNode , int prevNode , int[] ans){
        for(int child : adj.get(parentNode)){
            if(child == prevNode){
                continue;
            }
            ans[child] = ans[parentNode] - count[child] + (N - count[child]);
            DFS(adj , child , parentNode , ans);
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {

        //make adjcency list
        List<List<Integer>> adj = new ArrayList<>(); 

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        N = n;
        count = new int[n];
        int[] ans = new int[n]; 
        
        //to find parent/root result -> we write dfs for it
        dfs_root(adj , 0 , -1 , 0); // root (0) , previous -> -1 , dist = 0

        //we find root result using dfs_root function
        ans[0] = root_result;

        //for all nodes
        DFS(adj , 0 , -1 , ans);
        return ans;
    }
}