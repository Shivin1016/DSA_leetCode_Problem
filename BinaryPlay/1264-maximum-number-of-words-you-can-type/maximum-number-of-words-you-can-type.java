class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> brokenChar = new HashSet<>();
        for(char ch : brokenLetters.toCharArray()){
            brokenChar.add(ch);
        }

        String[] str = text.split(" ");
        boolean canType = true;
        int count = 0;

        for(int i = 0 ; i < str.length ; i++){
            String word = str[i];
            for(char ch : word.toCharArray()){
                if(brokenChar.contains(ch)){
                    canType = false;
                    break;
                }
            }
            if(canType == true){
                count++;
            }else{
                //for next word cantype ko true kr do
                canType = true;
            }
        }
        return count;
    }
}