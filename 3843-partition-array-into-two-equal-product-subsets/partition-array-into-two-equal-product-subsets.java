class Solution { 
    public boolean checkEqualPartitions(int[] nums, long target) {
        
        //multiply to all the nums then check it gives target after dividing the whole product

        long totalProd = 1;

        for(long num : nums){
            totalProd *= num;
        }
        
        if(totalProd != target * target){
            return false;
        } 

        Map<String , Boolean> mp = new HashMap<>();
        return solve(0 , nums , 1 , target , mp);  
    }

    public boolean solve(int i , int[] nums , long prod , long target ,Map<String , Boolean> mp)
    {
        String key = i + "," + prod;
        
        if(mp.containsKey(key)){
            return mp.get(key);
        }
        
        if(prod == target){
            return true;
        }

        if((prod > target) || (i == nums.length)) return false;
 

        //take 
        boolean take = solve(i + 1 , nums , prod * nums[i] , target , mp); 

        //skip
        boolean skip = solve(i + 1 , nums , prod , target , mp);

        mp.put(key , take || skip);

        return mp.get(key);
    }
}