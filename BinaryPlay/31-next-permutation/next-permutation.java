class Solution {
    private void swap(int[] nums , int l , int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    private void reverse(int[] nums , int l , int r){
        while(l < r){
            swap(nums , l , r);
            l++;
            r--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // find number from right side which satisfied that condition (nums[i - 1] < nums[i])
     
        int rightIdx = -1;
        for(int i = n - 1 ; i > 0 ; i--){
            if(nums[i - 1] < nums[i]){ 
                rightIdx = i - 1;
                break;
            }
        }

        if(rightIdx == -1){
            reverse(nums , 0 , n - 1); // reverse whole array
        }
        else{
            // find just greater number than rightNum on right side 
            int target = nums[rightIdx];
            int idx = -1; 
            for(int i = n - 1 ; i > rightIdx ; i--){
                if(nums[i] > target){ 
                    idx = i;
                    break;
                } 
            }
            // now swap  
            swap(nums , idx , rightIdx);
            // after that just reverse array from rightIdx + 1
            reverse(nums , rightIdx + 1 , n - 1);
        }
    }
}