class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;
        int[] frq = new int[101];

        for(int num : nums) frq[num]++;

        int maxFrq = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0 ; i <= 100 ; i++){
            if(frq[i] > maxFrq){ 
                maxFrq = frq[i];
            }
        }
        for(int f : frq){
            if(f == maxFrq) count += f;
        }

        return count;

    }
}