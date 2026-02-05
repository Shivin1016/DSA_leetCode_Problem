class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] t = new boolean[n + 1];

        t[0] = true;

        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(t[j] && wordDict.contains(s.substring(j , i))){
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n];
    }
}