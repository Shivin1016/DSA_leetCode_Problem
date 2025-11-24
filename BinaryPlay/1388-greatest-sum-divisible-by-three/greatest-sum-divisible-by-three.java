class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;

        List<Integer> rem_1 = new ArrayList<>();
        List<Integer> rem_2 = new ArrayList<>();

        int totalSum = 0;

        for(int i = 0 ; i < n ; i++){ 
            if(nums[i] % 3 == 1){
                rem_1.add(nums[i]);
            }else if(nums[i] % 3 == 2){
                rem_2.add(nums[i]);
            }
            totalSum += nums[i];
        }

        int reminder = totalSum % 3 ;
        if(reminder == 0) return totalSum;

        Collections.sort(rem_1);
        Collections.sort(rem_2);

        int res = 0;
        int size1 = rem_1.size();
        int size2 = rem_2.size();

        //reminder == 1 
        if(reminder == 1){
            int remove1 = size1 >= 1 ? rem_1.get(0) : Integer.MAX_VALUE;
            int remove2 = size2 >= 2 ? rem_2.get(0) + rem_2.get(1) : Integer.MAX_VALUE; 
            res = Math.max(res , totalSum - Math.min(remove1 , remove2)); 
        }else if(reminder == 2){
            int remove1 = size2 >= 1 ? rem_2.get(0) : Integer.MAX_VALUE;
            int remove2 = size1 >= 2 ? rem_1.get(0) + rem_1.get(1) : Integer.MAX_VALUE; 
            
            res = Math.max(res , totalSum - Math.min(remove1 , remove2));  
        }

        return res;
    }
}