class Solution {
    public int countTrapezoids(int[][] points) { 
        int n = points.length;
        long mod = 1000000007;
        Map<Integer , Long> mp = new HashMap<>();

        for(int[] p : points){ 
            int y = p[1]; //y-cordinates 
            mp.put(y , mp.getOrDefault(y , (long)0) + 1);
        }

        int size = mp.size();  
        long count = 0; 
        long sum = 0  ;
        for(long cnt : mp.values()){
            long pair = (cnt * (cnt - 1)) % mod / 2;
            count = (count % mod + (pair * sum)) % mod;
            sum += pair;
        }

        return (int)(count % mod);
    }
}