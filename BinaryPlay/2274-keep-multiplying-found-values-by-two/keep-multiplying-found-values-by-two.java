class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        long x = original;

        while(true){
            boolean find = false;
            for(int i = 0 ; i < n ; i++){
                if((long)(nums[i]) == x){
                    x = x * 2;
                    find = true; 
                } 
            }
            if(find == false){
                return (int)x;
            }
        }   
    }
}