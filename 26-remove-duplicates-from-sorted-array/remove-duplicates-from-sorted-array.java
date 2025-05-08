class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if(n == 1) return 1;
        
        int i = 0 , j = 0 ;

        //two pointer apporach
        while(j < n - 1){
            if(nums[j] == nums[j + 1]){
                j++;
            }else{
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        nums[i] = nums[j];
        return i + 1;
    }
}