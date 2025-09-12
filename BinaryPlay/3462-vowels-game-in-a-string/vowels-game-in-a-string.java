class Solution {
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public boolean doesAliceWin(String s) {
        int n = s.length();

        int vowelCnt = 0;
        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                vowelCnt++;
            }
        }
        return vowelCnt != 0;
    }
}