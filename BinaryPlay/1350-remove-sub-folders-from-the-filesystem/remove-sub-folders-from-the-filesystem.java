class Solution {
    public List<String> removeSubfolders(String[] folder) {

        int n = folder.length;

        //Sort them 
        Arrays.sort(folder); 
        List<String> ans = new ArrayList<>();

        String prev = folder[0]; 
        ans.add(folder[0]);

        for(int i = 1; i < n ; i++){
            String str = folder[i]; 
            //whole folder executed --> no subFolder 
            if(str.indexOf(prev + '/') != 0){
                ans.add(str);
                prev = str;
            }
        } 

        return ans;
    }
}