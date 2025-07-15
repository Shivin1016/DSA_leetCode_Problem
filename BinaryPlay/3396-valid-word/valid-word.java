class Solution {
    public boolean isValid(String word) {
        int vowelCnt = 0;
        int consonantCnt = 0;
        int digitCnt = 0;

        for(char ch : word.toCharArray()){
            if(Character.isDigit(ch)){
                digitCnt++;
            }
            else if(Character.isLetter(ch)){
                if(isVowel(ch)){
                    vowelCnt++;
                }else{
                    consonantCnt++;
                }
            }else{
                //another character inEcountered
                return false;
            }
        } 
        int len = consonantCnt + vowelCnt + digitCnt;
        if(consonantCnt > 0 && vowelCnt > 0 && len >= 3){
            return true;
        }
        return false;
    }

    public boolean isVowel(char ch){

        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }

        return false;

    }

}