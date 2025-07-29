class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] setBitIdx = new int[31];
        Arrays.fill(setBitIdx , -1);

        for(int i = n - 1 ; i >= 0 ; i--){
            int endIdx = i;
            for(int j = 0 ; j < 31 ; j++){
                if((nums[i] & (1 << j)) == 0){ //bit not set
                    if(setBitIdx[j] != -1){ 
                        endIdx = Math.max(endIdx , setBitIdx[j]);
                    }
                }else{
                    //already set hai but we have to take minimum
                    setBitIdx[j] = i;
                }
            }
            res[i] = endIdx - i + 1;
        }
        return res;
    }
}