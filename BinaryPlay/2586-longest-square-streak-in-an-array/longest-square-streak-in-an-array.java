class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;

        //without sorting
        Set<Integer> st = new HashSet<>();

        for(int num : nums) st.add(num);
        int maxStreak = 0;
        for(int num : nums){
            int currStreak = 0 ;
            long currNum = num;
            while(st.contains((int)currNum)){
                currStreak++;
                if(currNum * currNum > 1e5){
                    break;
                }
                currNum *= currNum;
            }
            maxStreak = Math.max(maxStreak , currStreak);
        }
        return maxStreak > 1 ? maxStreak : -1;
    }
}