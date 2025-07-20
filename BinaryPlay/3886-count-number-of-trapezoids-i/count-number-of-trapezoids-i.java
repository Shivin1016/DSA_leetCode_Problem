class Solution {
    public int countTrapezoids(int[][] points) {

        int n = points.length; 

        //take map --> store y-coordinates
        Map<Integer , Integer> mp = new HashMap<>();
        for(int[] point : points){
            int y_coordinate = point[1];
            mp.put(y_coordinate , mp.getOrDefault(y_coordinate , 0) + 1);
        }

        //make pairs 
        long[] pairs = new long[mp.size()];
        int i = 0;
        long mod = 1000000007;
        for(int val : mp.values()){
            long pair = (long)val * (val - 1) / 2 % mod;
            pairs[i++] = pair; 
        }
        
        //make groups of pairs which can make --> quadrilateral
        long ans = 0 , s = 0; 
        for(long p : pairs){
            ans = (ans + (p * s)) % mod;
            s = (s + p) % mod; 
        }

        return (int)(ans % mod);

        //don't worry --> one day you will pass this also --> just focus on consistency 
        //don't be deMotivated
        //you have to make your own ladders to climb up --> so it takes time
    }
}