class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> st  = new HashSet<>();
        int[] ans = new int[2];
        int i = 0;
        for(int num : nums){
            if(st.contains(num)){
                ans[i++] = num;
            }else{
                st.add(num);
            }
        }
        return ans;
    }
}