class Solution {
    public int countTrapezoids(int[][] points) { 
        int n = points.length;
        long mod = 1000000007;
        Map<Integer , Long> mp = new HashMap<>();

        for(int[] p : points){
            int y = p[1];
            mp.put(y , mp.getOrDefault(y , (long)0) + 1);
        }

        int size = mp.size(); 
        List<Long> pairs = new ArrayList<>();
        for(long cnt : mp.values()){
            long pair = ((cnt * (cnt - 1)) % mod / 2) % mod;
            pairs.add(pair);
        }

        long[] prefixSum = new long[size];
        prefixSum[0] = pairs.get(0);
        for(int i = 1 ; i < size ; i++){
            prefixSum[i] = (prefixSum[i - 1] + pairs.get(i)) % mod;
        }

        long count = 0;  
        for(int i = 0 ; i < size - 1 ; i++){
            count = (count % mod + (pairs.get(i) * (prefixSum[size - 1] - prefixSum[i])) % mod) % mod;
        }

        return (int)(count % mod);
    }
}