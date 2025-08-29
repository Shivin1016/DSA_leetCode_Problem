class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();

        int i = 0;
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        while (i < n) { 
            if(s.substring(0 , n - i).equals(str.substring(i , n))){
                break;
            }
            i++;
        }
        s = str.substring(0 , i).toString() + s;
        return s;
    }
}