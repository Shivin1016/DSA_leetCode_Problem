class Solution {
    int m ,n ;
    Map<String , Boolean> mp = new HashMap<>();
    public boolean solve(int i , int j , int[][] grid , int health){

        if(i >= m || j >= n){  
            return false;
        } 

        health += grid[i][j];

        if(health <= 0) return false;

        if(i == m - 1 && j == n - 1) return true; 

        String key = i + "_" + j + "_" + health;

        if(mp.containsKey(key)) return mp.get(key);

        boolean ans = solve(i , j + 1 , grid , health) || solve(i + 1 , j , grid , health);
        mp.put(key , ans);
        return  ans;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length; 

        int minHealth = 10000007 * 4;
        int l = 1;
        int r = 10000007 * 4; // 200 * 200 * 1000
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(solve(0 , 0 , dungeon , mid)){
               minHealth = mid;
               r = mid - 1;
            }else{
                l = mid + 1;
            } 
        }

        return minHealth;
    }


}