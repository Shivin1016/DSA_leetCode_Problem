class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long total = 0;
        for(int num : nums) total += num;

        int target = (int)(total % p);
        if(target == 0) return 0; 
        if(total < p) return -1; 
        
        int minLen = Integer.MAX_VALUE;  
        Map<Integer , Integer> mp = new HashMap<>() ; // store previus sum from 0 to i
        
        int currSum = 0; 
        mp.put(0 , -1); // intitally currSum
        for(int j = 0 ; j < n ; j++){   
            currSum = (currSum + nums[j]) % p; /// store module commulative sum 0 to j

            int find = (currSum - target + p) % p;
            if(mp.containsKey(find)){
                int i = mp.get(find); // commulative sum from 0 to i
                minLen = Math.min(minLen , j - i);
            }
            mp.put(currSum , j); //put every currSUm in hashMap
        } 
        
        return minLen == n ? -1 : minLen;
    }
}