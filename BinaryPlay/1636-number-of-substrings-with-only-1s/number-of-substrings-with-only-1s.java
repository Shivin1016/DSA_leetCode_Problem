class Solution {
    public int numSub(String s) {
        int n = s.length();

        int j = 0;
        int substrings = 0 , count = 0;
        int modulo = 1000000007;

        while(j < n){
            if(s.charAt(j) == '1'){
                count++;
            }else{
                count = 0;
            }
            j++;
            substrings = (substrings + count) % modulo ;
        }
        return substrings % modulo ;
    }
}