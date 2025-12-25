class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);

        long sum = happiness[n - 1]; // max value of happiness is at the end idx of aray
        int child = 1;
        for(int i = n - 2 ; i >= 0 ; i--){
            if((happiness[i] - child) > 0){ // child = 2
                happiness[i] -= child;
            }else{
                happiness[i] = 0;
            }
            //children == k break 
            if(child < k){ 
                sum += happiness[i];
                child++;
            }else break;
        }
        return sum;
    }
}