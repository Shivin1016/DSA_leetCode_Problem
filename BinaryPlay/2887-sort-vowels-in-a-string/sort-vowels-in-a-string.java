class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        char[] ans = s.toCharArray();
        var pq = new PriorityQueue<Character>((a , b) -> a - b);

        //time complexity -->O(nlogn)
        //space Complexity -->O(vowelsSize)

        for(int i = 0 ; i < n ; i++){ /// O(n) time
            if(isVowel(ans[i])){
                pq.add(ans[i]);
            }
        }

        if(pq.size() == 0) return s;

        int i = 0 ; 
        char lastElement = '/';
        while(!pq.isEmpty() && i < n ){
            if(isVowel(ans[i])){
                lastElement = pq.poll(); //logn time to pop the element  
                ans[i] = lastElement;
            }
            i++;
        }

        while(i < n){
            if(isVowel(ans[i])){
                ans[i] = lastElement;
            }
            i++;
        }

        return new String(ans); 
    }
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;
    }
}