class Solution { 
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        int maxLen = 0;

        for(int i = 0 ; i < n ; i++){
            Set<Integer> evenSt = new HashSet<>();
            Set<Integer> oddSt = new HashSet<>();
            for(int j = i ; j < n ; j++){
                if(nums[j] % 2 == 0){
                    evenSt.add(nums[j]);
                }else{
                    oddSt.add(nums[j]);
                }
                if(evenSt.size() == oddSt.size()){
                    maxLen = Math.max(maxLen , j - i + 1);
                }
            }
        }
        return maxLen;
    }
}