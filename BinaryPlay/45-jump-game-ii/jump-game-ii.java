class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(n == 1) return 0;

        int count = 0, farthest = 0 , currEnd = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            farthest = Math.max(farthest , i + nums[i]);
            
            if(i == currEnd){ //take jump when i reached currEnd
                count++;
                currEnd = farthest;
            }
          
        }
        return count;
    }
}