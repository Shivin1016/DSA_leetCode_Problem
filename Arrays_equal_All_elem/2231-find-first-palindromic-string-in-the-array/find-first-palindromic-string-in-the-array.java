class Solution {
    public String firstPalindrome(String[] words) {

        int n = words.length;

        for(String word : words){
            if(isPlainDrom(word.toCharArray())){
                return word;
            }
        }

        return "";

    }

    public boolean isPlainDrom(char[] word){
        int i = 0 , j = word.length - 1;
        while(i <= j){
            if(word[i] != word[j]) return false;
            i++;
            j--;
        } 
        return true;
    }
}