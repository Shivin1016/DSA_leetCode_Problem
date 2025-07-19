class Solution {
    public List<String> removeSubfolders(String[] folder) {

        int n = folder.length;

        Arrays.sort(folder);
        Set<String> st = new HashSet<>();

        st.add(folder[0]);

        for(int i = 1; i < n ; i++){

            String str = folder[i];

            boolean isSubFolder = false;
            String subStr = "/";
            int j = 1;
            while(j < str.length()){
                while(j < str.length() && str.charAt(j) != '/'){
                    subStr += str.substring(j , j + 1);
                    j++;
                }
                if(st.contains(subStr)){
                    //subFolder
                    isSubFolder = true;
                    break;
                }
                subStr += '/';
                j++;
            }

            //whole folder executed --> no subFolder
            if(isSubFolder == false){
                st.add(str);
            }
        }

        List<String> ans = new ArrayList<>();
        for(String str : st){
            ans.add(str);
        }
        return ans;
    }
}