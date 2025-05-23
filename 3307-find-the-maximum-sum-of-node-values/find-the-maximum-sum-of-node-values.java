class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int m = edges.length;
        int n = nums.length;

        //approach 01-->
        /* int cnt = 0;
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
            //we find nuksan because if cnt get odd so we have find its pair , so we have to find that node which have minimum nuksan on adding in sum 
            long nuksan = Math.abs(xor - num);
            minNuksan = (minNuksan > nuksan) ? nuksan : minNuksan;
            
        }

        if (cnt % 2 == 0) {
            return idealSum;
        }
        //if cnt is odd then remove last idex that we taken because lastIdx is added that is why cnt becomes odd  
        idealSum -= minNuksan;
        return idealSum ;
        */

        // Approach 02-->
        long idealSum = 0;
        for(int num : nums) idealSum += num;
        int[] profit = new int[n];

        for(int i = 0 ; i < n ; i++){
            int xor = nums[i] ^ k;
            int fayada = xor - nums[i];
            profit[i] = fayada;
        }

        //sort profit
        Arrays.sort(profit);
        int i = n - 1 , j = n - 2; 
        while(j >= 0){ 
            if(profit[i] + profit[j] > 0){
                idealSum += profit[i] + profit[j];
            }
            j -= 2;
            i -= 2;
        }
        return idealSum;


    }

}