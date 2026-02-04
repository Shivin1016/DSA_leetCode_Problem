class Solution {
    public int maximumValue(String[] strs) {
        int n = strs.length;

        int maxLen = 0;

        for(String str : strs){
            int currLen = 0;
            boolean alpha = false;
            for(char ch : str.toCharArray()){
                if(ch >= 'a' && ch <= 'z'){
                    alpha = true;
                    break;
                } 
            }
            if(alpha){
                currLen = Math.max(currLen , str.length());
            }else{
                currLen = Math.max(currLen , Integer.valueOf(str));
            }
            maxLen = Math.max(currLen , maxLen);
        }
        return maxLen;
    }
}