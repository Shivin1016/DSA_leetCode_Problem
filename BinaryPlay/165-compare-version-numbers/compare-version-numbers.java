class Solution {
    public int compareVersion(String version1, String version2) {
         
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");    

        int n1 = v1.length;
        int n2 = v2.length;
 

        int i = 0 , j = 0; 

        while(i < n1 && j < n2){
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[j]);
            // System.out.println(num1 + " " + num2);
            if(num1 < num2){
                return -1;
            }
            else if(num1 > num2){
                return 1;
            }
            i++;
            j++;
        }   

        while(i < n1){
            int num1 = Integer.parseInt(v1[i]);
            if(num1 > 0) return 1;
            i++;
        }

        while(j < n2){
            int num2 = Integer.parseInt(v2[j]);
            if(num2 > 0) return -1;
            j++;
        }

        return 0;
    }
}