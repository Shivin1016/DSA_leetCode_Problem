class Solution {
    public int triangularSum(int[] nums) {

        //Using extra array
        /*
          while(nums.length > 1){
            int newLen = nums.length - 1;
            int[] newNums = new int[newLen];
            int j = 0;
            while(j < newLen){
                newNums[j] = (nums[j] + nums[j + 1]) % 10;
                j++;
            }
            nums = newNums;
        }
        */

        //inPlace ChnageMent
        int n = nums.length;
        while(n > 1){  
            for(int i = 0 ; i < n - 1 ; i++){
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--;
        }
        return nums[0];
        
    }
}