class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        //it automatically sort time on basis on natural sorting
        TreeMap<Integer , List<int[]>> mp = new TreeMap<>();

        for(int[] meeting : meetings){
            int p1 = meeting[0];
            int p2 = meeting[1];
            int time = meeting[2];

            mp.computeIfAbsent(time , k -> new ArrayList<>()).add(new int[]{p1 , p2});
        }

        //make set which contains those person who know the secrets
        boolean[] knowSecretPersons = new boolean[n];
        //initially oth person and firstperson know the secret 
        knowSecretPersons[0] = true;
        knowSecretPersons[firstPerson] = true;

        //iterate over the map
        for(int time : mp.keySet()){
            Map<Integer , List<Integer>> adjList = new HashMap<>();
            var que = new LinkedList<Integer>();
            Set<Integer> alreadyAdded = new HashSet<>();
            for(int[] person : mp.get(time)){
                // make adj graph list  
                    int x = person[0];
                    int y = person[1]; 
                    
                    adjList.computeIfAbsent(x , k -> new ArrayList<>()).add(y);
                    adjList.computeIfAbsent(y , k -> new ArrayList<>()).add(x);

                    if(knowSecretPersons[x] && !alreadyAdded.contains(x)){
                        //if x know scecret then add in Queue if not added already
                        que.add(x);
                        alreadyAdded.add(x);
                    }
                    if(knowSecretPersons[y] && !alreadyAdded.contains(y)){
                        //if y know scecret then add in Queue if not added already
                        que.add(y);
                        alreadyAdded.add(y);
                    } 
            }

            //apply bfs
            while(!que.isEmpty()){
                int person = que.poll();
                for(int nextPerson : adjList.get(person)){
                    if(!knowSecretPersons[nextPerson]){
                        que.add(nextPerson);
                        knowSecretPersons[nextPerson] = true;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(knowSecretPersons[i] == true){
                ans.add(i);
            }
        }

        return ans;
        
    }
}