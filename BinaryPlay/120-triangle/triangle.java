class Solution {
    int m;
    Map<String , Integer> t = new HashMap<>();

    private int solve(List<List<Integer>> grid , int i , int j){
        if(i >= m || j >= grid.get(i).size()){
            return Integer.MAX_VALUE;
        }

        if(i == m - 1){
            return grid.get(i).get(j);
        }

        String key = i + "_" + j;
        if(t.containsKey(key)) return t.get(key);

        int ans = grid.get(i).get(j) + Math.min(solve(grid , i + 1 , j) , solve(grid , i + 1 , j + 1));
        t.put(key , ans);

        return ans;

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        m = triangle.size();
        return solve(triangle , 0 , 0);
    }
}