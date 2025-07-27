class Solution {
    public boolean isMonotonic(int[] nums) {

        int n = nums.length;
        if(n == 1) return true;
        boolean isMonotonic = false; 
        int i = 1;
        while(i < n){//check for increasing
            //if decreseing then break
            if(nums[i - 1] > nums[i]) break;
            i++;
        }
        if(i == n) return true;

        i = 1;
        while(i < n){ //check for decreasing
            //if increasing then break
            if(nums[i - 1] < nums[i]) break;
            i++;
        }
        return (i == n);
    }
}