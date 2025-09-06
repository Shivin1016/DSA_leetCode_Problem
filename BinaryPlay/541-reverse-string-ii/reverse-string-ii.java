class Solution {
    public String reverseStr(String s, int k) {

        int n = s.length();

        char[] word = s.toCharArray();

        for(int i = 0 ; i < n ; i += 2*k){
            if(n - i < k){
                reverse(i , n - 1 , word);
            }else if(n - i >= k && n - i < 2 * k){
                //reverse only k characters
                reverse(i , i + k - 1 , word);
            }else{
                //n - i > 2 *k
                reverse(i , i + k - 1 , word);
            }
        }

        return new String(word);

    }

    public void reverse(int i , int j , char[] word){
        while(i < j){
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
    }
}