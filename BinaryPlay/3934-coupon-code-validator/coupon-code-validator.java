class Solution {
    public boolean isValid(String code , String business){ 

        for(char ch : code.toCharArray()){
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || (ch == '_')){ 
                continue;
            }else return false;
        }

        if(business.equals("electronics") || business.equals("grocery") || business.equals("pharmacy") || business.equals("restaurant")){
            return true;
        }

        return false;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String[]> ans = new ArrayList<>();
        int n = code.length;

        for(int i = 0 ; i < n ; i++){ 
            String business = businessLine[i];
            if(code[i].length() == 0) continue;

            if(isValid(code[i] , business) && isActive[i]){ 
                ans.add(new String[]{code[i] , business});
            }
        } 
 

        // sort list on basis of bsuiess line
        Collections.sort(ans , (a , b) ->{ 
            int val = a[1].compareTo(b[1]);
            if(val == 0){
                return a[0].compareTo(b[0]);
            }
            return val;
        });
 

        List<String> result = new ArrayList<>();
        for(String[] ls : ans){
            result.add(ls[0]);
        }
        return result;
    }
}