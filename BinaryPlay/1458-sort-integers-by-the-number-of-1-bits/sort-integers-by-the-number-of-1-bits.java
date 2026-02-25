class Solution { 
    public int[] sortByBits(int[] arr) {  
        int n= arr.length;

        for(int i = 0 ; i < n; i++){
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < n; i++){
            arr[i] =  arr[i] % 10001;
        }
        return arr;
    }

    class BigCountComparator implements Comparator<Integer>{
        public int compare(Integer a ,Integer b){
            int counta = Integer.bitCount(a);
            int countb = Integer.bitCount(b);

            if(counta == countb) return a - b;
            else return counta - countb;
        }
    }
}