class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<Character> st = new HashSet<>();
        int count = 0;

        for(char ch : s.toCharArray()){
            st.add(ch);
        }

        for(char ch : st){
            int f = -1;
            int l = -1;
            for(int i = 0 ; i < n ; i++){
                if(ch == s.charAt(i)){
                    if(f == -1){
                        f = i;
                    }
                    l = i;
                }
            }
            if(f == l) continue; 
            HashSet<Character> st1 = new HashSet<>();
            for(int i = f + 1 ; i < l ; i++){
                st1.add(s.charAt(i));
            }
            count += st1.size();
        }
        return count;
    }
}