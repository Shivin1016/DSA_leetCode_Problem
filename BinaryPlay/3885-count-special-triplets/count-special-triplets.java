class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length; 
        long count = 0; 

        long M = 1000_000_007;

        Map<Integer , Long> leftMp = new HashMap<>(); 
        leftMp.put(nums[0] , (long)1); // zeroth idx element stores  

        Map<Integer , Long> rightMp = new HashMap<>();
        // /store  from 1 to n - 1 to rightMap
        for(int i = 1 ; i < n ; i++) rightMp.put(nums[i] , rightMp.getOrDefault(nums[i] ,(long)0) + 1);

        for(int j = 1 ; j < n - 1 ; j++){ 
            int doubleNum = nums[j] * 2;

            if(leftMp.containsKey(doubleNum) && rightMp.containsKey(doubleNum)){
                long frq1 = leftMp.get(doubleNum);
                long frq2 = rightMp.get(doubleNum);

                if(nums[j] == 0){ 
                    frq2 -= 1;
                }

                long minFrq = (frq1 * frq2) % M;
                 
                count = (count + minFrq) % M;
            }
            //update curr nums[j] in map 
            leftMp.put(nums[j] , leftMp.getOrDefault(nums[j] , (long)0) + 1);
            long frq = rightMp.getOrDefault(nums[j] , (long)0) - 1;
            if(frq == 0){
                rightMp.remove(nums[j]);
            }else if(frq > 0){
                rightMp.put(nums[j] , frq);
            }
        }

        return (int)count;

    }
}