class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer , List<Integer>> mp = new HashMap<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int key = i - j;
                if(!mp.containsKey(key)){
                    mp.put(key , new ArrayList<>());
                }
                mp.get(key).add(mat[i][j]);
            }
        }

        for(int key : mp.keySet()){
            List<Integer> ls = mp.get(key);
            Collections.sort(ls);
        }

        //generate ans in same mat
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int key = i - j;
                List<Integer> ls = mp.get(key);
                mat[i][j] = ls.get(0); // put first element at (i ,j) gives in sorted fashion

                //now remove that zero idx element from ls
                ls.remove(0) ; // 0th idx element removed
                if(ls.size() != 0){
                    mp.put(key , ls);
                }else{
                    mp.remove(key);
                }
            }
        }

        return mat;

    }
}