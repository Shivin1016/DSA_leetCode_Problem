class Solution {
    public int[] smallestSubarrays(int[] nums) {

        /*
        int n = nums.length;
        int[] ans = new int[n];

        int[] setBitIdx = new int[31];
        Arrays.fill(setBitIdx , -1);
        // setbitIdx[j] = i that mean jth bit can be set by idx = i element 

        //traversal from right to left --> to get minimum idx which sets the bits
        for(int i = n - 1 ; i >= 0 ; i--){
            //set all bits of nums[i] if possible with minimum idx because to get short length of subArray
            //binary representation of nums[i]
            int endIdx = i;
            for(int j = 0 ; j < 31 ; j++){
                if((nums[i] & (1 << j)) == 0){  // bit not set
                    if(setBitIdx[j] != -1){
                        //we maximize it to check that sari bits ko set krne ke liye kaha tk jana padega
                        endIdx = Math.max(endIdx , setBitIdx[j]);
                    }else{
                        //jth bit set --> then store minimum idx to set it
                        setBitIdx[j] = i;
                    }
                }
            }
            System.out.println(endIdx);
            ans[i] = endIdx - i + 1;
        }
        return ans;
        */


        int n = nums.length;
        int[] result = new int[n];
        int[] setBitIndex = new int[31];
        Arrays.fill(setBitIndex, -1);

        for (int i = n - 1; i >= 0; i--) {
            int endIndex = i;
            for (int j = 0; j < 31; j++) {
                if ((nums[i] & (1 << j)) == 0) {
                    if (setBitIndex[j] != -1) {
                        endIndex = Math.max(endIndex, setBitIndex[j]);
                    }
                } else {
                    setBitIndex[j] = i;
                }
            }
            result[i] = endIndex - i + 1;
        }

        return result;
    }
}