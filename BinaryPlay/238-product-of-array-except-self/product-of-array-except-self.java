class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int countZeros = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                countZeros++; 
            }
            if(countZeros > 1) return ans;
        }
 
        int zeroIdx = -1;
        int prod = 1;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 0){
                zeroIdx = i;
                continue;
            }
            prod *= nums[i];
        }

        if(zeroIdx != -1){
            ans[zeroIdx] = prod;
            return ans;
        }

        for(int i = 0 ; i < n ; i++){
            ans[i] = prod / nums[i];
        }

        return ans;




        // -1 , 1 , 0 , -3 , 3 -->  
        // -1 , 1 , 0 , -3 , 0 -->
    }
}