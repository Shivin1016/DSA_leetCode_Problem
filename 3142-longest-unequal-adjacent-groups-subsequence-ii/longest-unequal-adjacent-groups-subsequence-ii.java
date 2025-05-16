class Solution {
    
    public int hummingDis(String w1 , String w2 , int n){

        if(w1.length() != w2.length()) return 0;

        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(w1.charAt(i) != w2.charAt(i)) cnt++;
            if(cnt > 1) return cnt;
        }

        return cnt;
    } 

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;

        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx , -1);
        int LISIdx = -1;
        int maxLen = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(groups[j] != groups[i] && hummingDis(words[i] , words[j] , words[i].length()) == 1){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        prevIdx[i] = j;

                        //update maxLen
                        if(maxLen < dp[i]){
                            maxLen = dp[i];
                            LISIdx = i;
                        }
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>(); ///it stores in reverse pattern 
        while(LISIdx != -1){
            ans.add(words[LISIdx]);
            LISIdx = prevIdx[LISIdx];
        }

        //there is no pair found which hold given conditions
        if(ans.size() == 0){
            ans.add(words[n - 1]);
            return ans;
        }

        //reverse ans so that it becomes pattern as given in array
        reverse(ans , ans.size());
        return ans;
    }

    public void reverse(List<String> ans , int n){
        for(int i = 0 ; i < n / 2 ; i++){
            String temp = ans.get(i);
            ans.set(i , ans.get(n - i - 1));
            ans.set(n - i - 1 , temp);
        }
    }
}