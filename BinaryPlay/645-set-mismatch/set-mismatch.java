class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            if(st.contains(nums[i])){
                //repeated
                ans.add(nums[i]);
            }else{
                st.add(nums[i]);
            }
        }
        //missing numbers
        for(int i = 1 ; i <= n ; i++){
            if(!st.contains(i)){
                //found missing number
                ans.add(i);
            }
        }

        return ans.stream().mapToInt(x -> x).toArray();
    }
}