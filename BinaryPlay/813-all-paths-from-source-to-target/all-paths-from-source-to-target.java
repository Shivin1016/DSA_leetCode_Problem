class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        dfs(graph , 0 , n - 1 , result , temp);

        return result;
    }

    public void dfs(int[][] graph , int u , int desti , List<List<Integer>> result , List<Integer> temp){

        temp.add(u); //current path running

        if(u == desti){
            //current path completed
            result.add(new ArrayList<>(temp)); 
        }else{
            for(int v : graph[u]){
                dfs(graph , v , desti , result , temp);
            }
        }
        //remove current path 
        temp.remove(temp.size() - 1);
    }
}