class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Map<Integer , List<Integer>> mp = new HashMap<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int key = i - j ;
                if(!mp.containsKey(key)){
                    mp.put(key , new ArrayList<>());
                }
                mp.get(key).add(grid[i][j]);
            }
        }

        for(int key : mp.keySet()){
            List<Integer> ls = mp.get(key);
            Collections.sort(ls);
            if(key >= 0){
                //make non - increasing order for bottom - left
                Collections.reverse(ls);
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int key = i - j;
                List<Integer> ls = mp.get(key);
                grid[i][j] = ls.get(0);
                ls.remove(0);
                if(ls.size() == 0){
                    mp.remove(key);
                }else{
                    mp.put(key , ls);
                }
            }
        }
        return grid;
    }
}