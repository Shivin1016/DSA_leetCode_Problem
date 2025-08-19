class Solution {
    public int numberOfArithmeticSlices(int[] nums) { 
        int n = nums.length;
        
        // length must be at least 3
        if(n < 3) return 0;

        int i = 0 , j = 2;
        int sub = 0; 
        int diff = nums[1] - nums[0];
        int currDiff = 0;
        int cnt = 1;

        while(j < n){
            currDiff = (nums[j] - nums[j - 1]);
            if(currDiff == diff){
                if(j - i + 1 == 3){
                    //equal to 3 length means new slice
                    sub++;
                    cnt = 1; //new slice found so reset it
                }else if(j -  i + 1 > 3){
                    //more than 3 length means same slice 
                    sub += (cnt + 1);
                    cnt++;
                }
            }else{
                //not equal
                i = j - 1;
                //new diff
                diff = currDiff;
            }
            j++;
        }
        return sub;

    }
}