class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        
        //starting me hi deCreasing mil gaya
        if(nums[0] >= nums[1]) return false;

        int i = 1;
        while(i < n){
            if(nums[i] == nums[i - 1]) return false;
            //now we have to find dcreament count
            if(nums[i - 1] > nums[i]){
                break;
            }
            i++;
        }
        if(i == n) return false;
        //for dcreasing
        while(i < n){
            if(nums[i] == nums[i - 1]) return false;
            if(nums[i - 1] < nums[i]){ //found increasing
                break;
            }
            i++;
        }
        if(i == n) return false;
        //for increasing
        while(i < n ){
            if(nums[i] == nums[i - 1]) return false;
            if(nums[i - 1] > nums[i]){ //found dcreasing
                break;
            }
            i++;
        }

        return i == n ? true : false;
    }
}