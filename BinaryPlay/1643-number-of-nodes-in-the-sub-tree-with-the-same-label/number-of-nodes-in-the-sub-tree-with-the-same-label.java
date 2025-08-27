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
        int[] myCnt = new int[26]; // my cnt of 0th node

        dfs(adj , 0 , -1 , labels , ans );
        return ans;
    }

    public int[] dfs(List<List<Integer>> adj , int curr , int parent , String labels , int[] ans){ 
        int[] myCnt = new int[26];
        char label = labels.charAt(curr);
        myCnt[label - 'a'] = 1;

        for(int child : adj.get(curr)){
            if(child == parent){
                continue;
            }

            int[] childCnt = dfs(adj , child , curr , labels , ans);

            //update myCnt from childCnt
            for(int i = 0 ; i < 26 ; i++){
                myCnt[i] += childCnt[i];
            }

        }
        //update result using myCnt
        ans[curr] = myCnt[label - 'a']; 
        return myCnt;
    }
}