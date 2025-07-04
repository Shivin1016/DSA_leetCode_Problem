class Solution {
    public String[] findWords(String[] words) {

        List<String> ans = new ArrayList<>();

        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";



        for(String word : words){
            //for row1 
            if(check(word.toCharArray() , row1)){
                ans.add(word); 
            }else if(check(word.toCharArray() , row2)){
                ans.add(word); 
            }else if(check(word.toCharArray() , row3)){
                ans.add(word);
            }
        }

        String[] res = new String[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    public boolean check(char[] word , String row){
        boolean isfound = true; 
        for(char ch : word){ 
            if((row.indexOf(ch) == -1) && (row.indexOf(ch + 32) == -1)){
                isfound = false;
                break;
            }
        }
        return isfound;
    }
}