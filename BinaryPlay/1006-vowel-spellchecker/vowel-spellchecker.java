class Solution { 
    public String vowel(String str){
        char[] vowelStr = str.toCharArray();
        for(int j = 0 ; j < vowelStr.length ; j++){
            char ch = vowelStr[j];
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                ch = '*';
               vowelStr[j] = ch;
            }
        }
        return new String(vowelStr);
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int m = queries.length;
        int n = wordlist.length;

        Set<String> exactSet = new HashSet<>();
        Map<String , String> caseMap = new HashMap<>();
        Map<String , String> vowelMap = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            String str = wordlist[i];

            // add in exact Set
            exactSet.add(str);

            //for caseMap -> make all chars small then map to original str
            String smallStr = str.toLowerCase();
            //now add smallStr to caseMAp
            if(!caseMap.containsKey(smallStr)){
                caseMap.put(smallStr , str);
            }

            //for vowels make * to vowels character
            String vowelStr = vowel(smallStr); 
            if(!vowelMap.containsKey(vowelStr)){
                vowelMap.put(vowelStr , str);
            }
        }

        String[] ans = new String[m];

        for(int i =0 ; i < m ; i++){
            String q = queries[i];
            String lower = q.toLowerCase();
            String vowelCase = vowel(lower); 

            if(exactSet.contains(q)){
                ans[i] = q;
            }else if(caseMap.containsKey(lower)){
                ans[i] = caseMap.get(lower);
            }else if(vowelMap.containsKey(vowelCase)){
                ans[i] = vowelMap.get(vowelCase);
            }else{
                ans[i] = "";
            }
        }

        return ans;
    }
}