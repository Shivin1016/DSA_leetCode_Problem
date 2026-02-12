class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i = 0 ; i < n ; i++){
            int[] frq = new int[26];
            for(int j = i ; j < n ; j++){
                frq[s.charAt(j) - 'a']++; 
                boolean get = true;  
                int firstFrq = -1;
                for(int f : frq){ 
                    if(f > 0){
                        if(firstFrq == -1){
                            firstFrq = f;
                        }else if(firstFrq != f){
                            get = false;
                            break;
                        }
                    } 
                }
                if(get){
                    maxLen = Math.max(maxLen , j - i + 1);
                }
            }
        }

        return maxLen;
    }
}