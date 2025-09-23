class Solution { 
    
    public void dfs(List<List<Integer>> adj , int u , boolean[] visited){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(!visited[v]){
                dfs(adj , v , visited);
            }
        }
    }
    public boolean isIdentical(String s1 , String s2){
        int cnt = 0;
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }

            if(cnt > 2) return false;
        }
        return (cnt == 2 || cnt == 0);
    }

    public int numSimilarGroups(String[] strs) {

        int n = strs.length;

        //using DFS
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        } 

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1; j < n ; j++){
                if(isIdentical(strs[i] , strs[j])){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int grp = 0; 
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(adj , i , visited);
                grp++;
            }
        }
        return grp;
    }
}