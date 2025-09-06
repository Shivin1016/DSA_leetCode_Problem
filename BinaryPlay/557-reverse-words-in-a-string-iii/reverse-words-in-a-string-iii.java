class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] word = s.toCharArray();

        int firstIndex = 0;
        for(int i = 0 ; i < n ; i++){
            if(word[i] == ' '){
                reverse(firstIndex , i - 1 , word);
                firstIndex = i + 1;
            }
        }
        //for last sentance
        reverse(firstIndex , n - 1 , word);
        return new String(word);
    }

    public void reverse(int l , int r , char[] word){
        while(l < r){
            char temp = word[l];
            word[l] = word[r];
            word[r] = temp;
            l++ ;
            r--;
        }

    }
}