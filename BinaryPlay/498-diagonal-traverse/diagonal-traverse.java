class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int k = 0;
        int[] ans = new int[m * n];

        Map<Integer , List<Integer>> mp = new HashMap<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int key = (i + j);
                if(!mp.containsKey(key)){
                    mp.put(key , new ArrayList<>());
                }
                mp.get(key).add(mat[i][j]);
            }
        }

        //store list at crrosposnding key 
        for(int key : mp.keySet()){
            List<Integer> ls = mp.get(key); 
            if(key % 2 == 0){
                Collections.reverse(ls);
            }
            for(int val : ls){
                ans[k++] = val;
            }
        }
        return ans;

       

    }
}