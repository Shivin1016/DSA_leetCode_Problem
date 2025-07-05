class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;

        //Constant space complexity
        // int[] frq = new int[501];

        // for(int num : arr){
        //     frq[num]++;
        // }

        // int lucky = -1;
        // for(int i = 1 ; i < 501 ; i++){ 
        //     if(i == frq[i]){
        //         lucky = Math.max(lucky , frq[i]);
        //     }
        // }

        // return lucky;

        //Inplace O(1) space complxity

        for(int num : arr){
            // num can be modified so taking AND with 2 ^ 16 gives real value 
            int val = (num & 65535);

            if(val <= n){
                arr[val - 1] += (1 << 16); // add 
            }
        }

        for(int val = n ; val >= 1 ; val--){
            //possibel values --> val
            //gives frq count ->arr[val - 1] >> 16 --> right shift of number 16 times
            if((arr[val - 1] >> 16) == val){
                return val;
            }
        }
        return -1;
    }
}