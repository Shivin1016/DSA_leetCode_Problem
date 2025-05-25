class Solution {
    public int longestPalindrome(String[] words) {
        int n = words.length;
        int len = 0;

        Map<String , Integer> mp = new HashMap<>(); 

        for(String st : words){
            String rev = new String(reverse(st.toCharArray()));
            //if reverse of st in map
            if(mp.containsKey(rev)){
                len += 4;
                int left = mp.get(rev) - 1;
                if(left == 0) mp.remove(rev);
                else mp.put(rev , left);
            }else{
                mp.put(st , mp.getOrDefault(st , 0) + 1);
            }
        }

        //check for duplicates
        for(String st : mp.keySet()){
            int val = mp.get(st);
            if(st.charAt(0) == st.charAt(1) && val > 0){
                len += 2;
                break; // you can use only once that is used in middle
            }
        }
        return len;
    } 

    public char[] reverse(char[] s){
        int n = s.length;
        int i =0 , j = n -1;
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return s;
    }
}