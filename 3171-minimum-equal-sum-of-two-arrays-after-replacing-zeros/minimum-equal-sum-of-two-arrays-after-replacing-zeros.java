class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int numberOfZeros1 = 0;
        int numberOfZeros2 = 0;

        long sum1 = 0 , sum2 = 0;
        
        for(int num1 : nums1){
            if(num1 == 0){
                numberOfZeros1++;
                sum1++;
            }
            sum1 += num1;
        }

        for(int num2 : nums2){
            if(num2 == 0){
                numberOfZeros2++;
                sum2++;
            }
            sum2 += num2;
        } 
        //if testCase like num1 has zeros zero and sum2 is larger than sum1 then we cannot make array aum equal same for other
        //{4,5} and {3 ,2 ,0 , 8 , 0} --> we cant make it equal
        if((numberOfZeros1 == 0 && sum2 > sum1) || (numberOfZeros2 == 0 && sum1 > sum2)) return -1;

        //else return maxSum which got from both arrays after adding each zeros to 1 
        return Math.max(sum1 , sum2);
    }
}