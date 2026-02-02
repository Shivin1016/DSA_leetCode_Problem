class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        Map<Character , Integer> mp = new HashMap<>();

        for(char ch : s.toCharArray()){
            mp.put(ch , mp.getOrDefault(ch , 0) + 1);
        }

        List<Character> sortChar = new ArrayList<>(mp.keySet());
        Collections.sort(sortChar , (a , b) -> mp.get(b) - mp.get(a));
        
        StringBuilder ans = new StringBuilder();
        for(char ch : sortChar){ 
            ans.append(String.valueOf(ch).repeat(mp.get(ch))); 
        }

        return ans.toString();
    }
}