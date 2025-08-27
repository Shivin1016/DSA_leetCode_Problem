class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //make adjancy list
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return dFS(adj , 0 , -1 , hasApple);
    }
    public int dFS(List<List<Integer>> adj , int curr , int parent , List<Boolean> hasApple){
        int time = 0;
        for(int child : adj.get(curr)){
            if(child == parent){
                continue; // vapis se mat jao wahi
            }

            int time_from_child_to_collect_apple = dFS(adj , child , curr , hasApple);

            if(time_from_child_to_collect_apple > 0 || hasApple.get(child) == true){
                time += time_from_child_to_collect_apple + 2;
                //2 for current child
            } 
        }
        return time;
    }
}