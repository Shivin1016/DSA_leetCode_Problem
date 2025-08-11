class Solution {
    public int[] productQueries(int n, int[][] queries) {

        int mod = (int)(1e9 + 7);
        int q = queries.length;

        // 1-> make power array
        List<Integer> power = new ArrayList<>(); 
        for(int i = 0 ; i < 31 ; i++){
            if((n >> i & 1) == 1) power.add(1 << i);
        }

        int[] ans = new int[q];
        for(int i = 0 ; i < q ; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            long prod = 1;

            for(int j = left ; j <= right ; j++){
                prod = (prod * power.get(j)) % mod;
            }
            ans[i] =(int)prod;
        }

        return ans;
    }
}