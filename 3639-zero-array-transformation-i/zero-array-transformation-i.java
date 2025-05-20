class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = queries.length;
        int m = nums.length;
        
        //BruteForce Approach-> Time Limit Exceded
        // for(int i = 0 ; i < n ; i++){
        //     int start = queries[i][0];
        //     int end = queries[i][1];
        //     for( ; start <= end ; start++){
        //         if(nums[start] != 0){
        //             nums[start]--;
        //         }
        //     }
        // } 

        //Btter approach(Optimal approach)--> using difference array technique
        int[] diff = new int[m];

        for(int[] q :queries){
            int start = q[0];
            int end = q[1];
            int x = 1;

            diff[start] += x;
            if(end + 1 < m) diff[end + 1] -= x; 
        }

        //now take commulative sum and also check it that it have operation >= nums[i]
        int commSum = 0;
        int[] res = new int[m]; // store number of operation to be performed
        for(int i =0 ; i < m ; i++){
            commSum += diff[i];
            res[i] = commSum;
        }

        for(int i = 0 ; i < m ; i++){
            if(res[i] < nums[i]){ //nums[i] won't become zero ever because number operation less then that nums[i];
                return false;
            }
        }

        return true;
         
    }
}