class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int n = s.length();

        //bruteForce Approach--> TIme limit Exceded
        // while(t > 0){
        //     StringBuilder sb = new StringBuilder();
        //     for(char ch : s.toCharArray()){
        //         if(ch == 'z'){
        //             sb.append("ab");
        //         }else{
        //             sb.append((char)(ch + 1));
        //         }
        //     }
        //     s = sb.toString();
        //     t--;
        // }
        // return s.length();

        //using map
        long[] mp = new long[26];
        long m = 1000000007;

        for(char ch : s.toCharArray()){
            mp[ch - 'a']++;
        }

        while(t > 0){
            long[] temp = new long[26];
            for(int i = 0 ; i < 26 ; i++){
                if(mp[i] != 0){
                    long frq = mp[i];
                    char ch = (char)('a' + i); 
                    if(ch == 'z'){
                        temp[0] = (temp[0] + frq) % m;
                        temp[1] = (temp[1] + frq) % m;
                    }else{
                        temp[ch - 'a' + 1] = (temp[ch -'a' + 1] + frq) % m;
                    }
                }
            }
            mp = temp.clone(); 
            t--;
        }
        
        long size = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(mp[i] != 0) size = (size + mp[i]) % m;
        }
        return (int)(size % m);
    }
}