class Solution {
    public List<String> buildArray(int[] target, int n) {
        int len = target.length; 
        List<String> ans = new ArrayList<>();

        int j = 0;
        for(int i = 1 ; i <= n ; i++){
            int num = target[j]; 
            ans.add("Push");
            if(num == i){ 
                j++;
            }else{
                ans.add("Pop");
            }

            if(j == len) return ans;
        }

        return ans;
    }
}