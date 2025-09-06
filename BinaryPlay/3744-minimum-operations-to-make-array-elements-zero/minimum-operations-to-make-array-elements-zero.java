class Solution {
    public long solve(long l , long r){
        long L = 1; 
        long steps = 0;
        long s = 1;

        long size = r - l + 1;
        while(size > 0){
            long R = 4 * L - 1;
            long start = Math.max(L , l);
            long end = Math.min(R , r);

            if(start <= end){ 
                long element = end - start + 1;
                steps += element * s;
                size -= element;
            }
            s++;
            L = L * 4;
        }
        return steps;
    }
    public long minOperations(int[][] queries) {

        int n = queries.length;

        long result = 0;

        for(int[] q : queries){

            long l = q[0];
            long r = q[1];

            long steps = solve(l , r);

            result += (steps + 1) / 2;
        }
        System.out.println(result);

        return result ;
    }
}