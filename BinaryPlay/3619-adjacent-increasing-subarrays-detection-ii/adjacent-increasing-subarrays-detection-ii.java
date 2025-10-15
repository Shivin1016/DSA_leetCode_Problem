class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int prevLen = 0;
        int currLen = 1;

        int maxK = Integer.MIN_VALUE;

        for(int i = 1 ; i < n ; i++){
            if(nums.get(i) > nums.get(i - 1)){
                currLen++;
            }else{
                prevLen = currLen;
                currLen = 1;
            }

            if(currLen % 2 == 0){
                maxK = Math.max(maxK , currLen / 2);
            } 
            maxK = Math.max(maxK , Math.min(prevLen , currLen)); 
        }
        return maxK;
    }
}