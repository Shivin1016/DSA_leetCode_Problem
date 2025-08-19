class Solution {
    public boolean isDifferOne(String s1 , String s2){
        int diff = 0;
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
                if(diff > 1) return false;
            }
        }
        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        var que = new LinkedList<String>();
        que.add(beginWord);

        //visited set
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){

                String word = que.pop();

                //check is this last word
                if(word.equals(endWord)){
                    return level + 1;
                }

                //check for further
                for(int i = 0 ; i < wordList.size() ; i++){
                    String newWord = wordList.get(i);
                    if(!visited.contains(newWord) && isDifferOne(newWord , word)){
                        que.add(newWord);
                        visited.add(newWord);
                    }
                }
            }
            level++;
        }
        return 0; //no such sequence exist

    }
}