class Solution {

    public String removeSubStr(String str , String matchStr){

        int n = str.length();
        StringBuilder sb = new StringBuilder(str);
        //without using stack
        /*Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            char ch = str.charAt(i);
            if(ch == matchStr.charAt(1) && !st.empty() && st.peek() == matchStr.charAt(0)){
                st.pop();
            }else{
                st.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        return sb.toString();
        */

        int i = 0 ; //for writing purpose
        for(int j = 0 ; j < n ; j++){ //for reading each character

            //whatever j reads it will print on i'th pointer
            sb.setCharAt(i , sb.charAt(j));

            // increament i and check that before i is there any matchString
            i++;
            if(i >= 2 && sb.charAt(i - 2) == matchStr.charAt(0) && sb.charAt(i - 1) == matchStr.charAt(1)){
                i -= 2;
            }

        }
        //erase character from i to n
        sb.delete(i , n);
        return sb.toString();

    }
    public int maximumGain(String s, int x, int y) {
        int n = s.length();

        int score = 0;
        String maxString = (x >= y) ? "ab" : "ba";
        String minString = (x < y) ? "ab" : "ba"; 

        //first pass is for max point --> for starting string
        String first_pass = removeSubStr(s , maxString);
        int len = first_pass.length();
        int removedChar = n - len; 
        //removed character is maxStr --> so make pair for score 
        score += (removedChar / 2) * Math.max(x , y);
        // System.out.println(maxString);

        //second pass is for min point --> remaining string-->after deleting first pass string
        // System.out.println(first_pass + " " + minString);
        String second_pass = removeSubStr(first_pass , minString);
        int remainLen = second_pass.length();
        removedChar = len - remainLen ;
        score += (removedChar / 2) * Math.min(x , y);
        // System.out.println(score + " " + remainLen);

        return score;
    }
}