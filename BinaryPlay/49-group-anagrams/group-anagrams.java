class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        List<List<String>> ans = new ArrayList<>();
        Map<String , List<Integer>> mp = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);  
            mp.computeIfAbsent(new String(ch) , k -> new ArrayList<>()).add(i);
        }

        for(String key : mp.keySet()){
            // get all idx of same anagrams strings
            List<String> temp = new ArrayList<>();
            for(int i : mp.getOrDefault(key , new ArrayList<>())){ 
                temp.add(strs[i]);
            } 
            ans.add(temp);
        }

        return ans;

    }
}