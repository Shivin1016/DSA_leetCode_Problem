class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;

        List<String> ans = new ArrayList<>();

        for(String str : words){
            ans.add(str);
        }

        for(int i = 0 ; i < ans.size() ; i++){
            int j = i + 1;
            while(j < ans.size()){
                if(isAnagrams(ans.get(i) , ans.get(j))){
                    ans.remove(j);
                }else{
                    break;
                }
            }
        }

        return ans;
    }

    public boolean isAnagrams(String str1 , String str2){
        if(str1.length() != str2.length()) return false;

        int[] frq = new int[26];
        for(int i = 0 ; i < str1.length() ; i++){
            char ch = str1.charAt(i);
            frq[ch - 'a']++;
        }

        for(int i = 0 ; i < str2.length() ; i++){
            char ch = str2.charAt(i); 
            frq[ch - 'a']--; 
        }

        for(int i = 0 ; i < 26 ; i++){
            if(frq[i] != 0) return false;
        }
        return true;

    }
}