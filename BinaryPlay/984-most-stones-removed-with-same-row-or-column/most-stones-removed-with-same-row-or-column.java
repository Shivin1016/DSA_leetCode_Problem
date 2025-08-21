class Solution {
    public boolean isSameGrp(int i , int j , int[][] stones){
        if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
            return true;
        }
        return false;
    }
    public void dfs(int[][] stones , int i , boolean[] visited){

        visited[i] = true;

        for(int j = 0 ; j < stones.length ; j++){
            if(!visited[j] && isSameGrp(i , j , stones)){ 
                dfs(stones , j , visited);
            }
        }
    }
    public int removeStones(int[][] stones) {

        int n = stones.length; // number of stones

        //using DFS
        int group = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(stones , i , visited);
                group++;
            }
        }
 
        return  n - group;
    }
}