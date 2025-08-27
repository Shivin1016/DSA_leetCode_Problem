class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] ans = new int[n]; 
        int[] label_cnts = new int[26]; // my cnt of 0th node

        dfs(adj , 0 , -1 , labels  , ans , label_cnts);
        return ans;
    }

    public void dfs(List<List<Integer>> adj , int curr , int parent , String labels , int[] ans , int[] label_cnts){ 
        
        char label = labels.charAt(curr);

        //stores value count of the label before coming to curr node
        int before = label_cnts[label - 'a'];
        label_cnts[label - 'a'] += 1;

        for(int child : adj.get(curr)){
            if(child == parent){
                continue;
            }

            dfs(adj , child , curr , labels , ans , label_cnts); 

        }
        //after visiting the curr , my label count
        int after = label_cnts[label - 'a'];
        //update result
        ans[curr] = after - before; 
    }
}