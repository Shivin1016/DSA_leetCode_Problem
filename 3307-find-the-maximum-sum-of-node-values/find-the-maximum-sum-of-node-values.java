class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int m = edges.length;
        int n = nums.length;

        int cnt = 0;
        long idealSum = 0;  
        //if cnt is odd then take that xor values which give minimum nuksan
        long minNuksan = Integer.MAX_VALUE;

        for (long num : nums) {
            long xor = (num ^ k);
            if(xor > num){
                idealSum += xor; 
                cnt++;
            }else{
                idealSum += num;
            }
            long nuksan = Math.abs(xor - num);
            minNuksan = (minNuksan > nuksan) ? nuksan : minNuksan;
            
        }

        if (cnt % 2 == 0) {
            return idealSum;
        }
        //if cnt is odd then remove last idex that we taken because lastIdx is added that is why cnt becomes odd  
        idealSum -= minNuksan;
        return idealSum ;

    }

}