class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        int m = friendships.length;

        Map<Integer , Set<Integer>> langKnowsByUser = new HashMap<>();
        for(int i = 0 ; i < languages.length ; i++){
            int[] lang = languages[i]; 
            for(int l : lang){
                langKnowsByUser.computeIfAbsent(i + 1 , k -> new HashSet<>()).add(l);
            }
        }

        Set<Integer> saduser = new HashSet<>();

        for(int[] f : friendships){

            int u = f[0];
            int v = f[1];
            //find common langauges who knows both
            Set<Integer> commonLang = new HashSet<>(langKnowsByUser.getOrDefault(u , new HashSet<>()));
            commonLang.retainAll(langKnowsByUser.getOrDefault(v , new HashSet<>()));

            if(commonLang.size() == 0){
                //no common languages found 
                saduser.add(u);
                saduser.add(v);
            }
        }

        //iterate over each languages 
        int minUsers = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n ; i++){
            int count = 0;
            for(int u : saduser){
                if(!langKnowsByUser.getOrDefault(u , new HashSet<>()).contains(i)){
                    //not know then teach lang
                    count++;
                }
            }
            System.out.println(count);
            minUsers = Math.min(minUsers , count);
        }

        return minUsers;

    }
}