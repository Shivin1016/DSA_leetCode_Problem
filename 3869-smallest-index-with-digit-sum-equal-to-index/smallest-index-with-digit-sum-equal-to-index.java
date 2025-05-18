class Solution {
    public int smallestIndex(int[] nums) {
        int idx = -1;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(i == digitSum(nums[i])){
                return i;
            }
        }
        return -1;
    }
    public int digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}