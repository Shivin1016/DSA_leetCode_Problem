class Router {
    Queue<String> que;
    Map<String , int[]> packetStore;
    int size ;
    Map<Integer , List<Integer>> destTime;
    Map<Integer , Integer> startIndex;
    public Router(int memoryLimit) {
        size = memoryLimit;
        que = new LinkedList<>();
        packetStore = new HashMap<>();
        startIndex = new HashMap<>();
        destTime = new HashMap<>();
    }

    public String make_key(int src , int desti , int time){
        return src + "#" + desti + "#" + time;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String str = make_key(source, destination, timestamp);

        if(packetStore.containsKey(str)){
            return false;
        }

        if(que.size() == size){
            forwardPacket();
        }
        que.add(str);
        packetStore.put(str , new int[]{source, destination, timestamp});
        destTime.putIfAbsent(destination , new ArrayList<>());
        destTime.get(destination).add(timestamp);
        startIndex.putIfAbsent(destination , 0);
        return true;
    }
    
    public int[] forwardPacket() {
        if(que.size() > 0){
            String packet = que.poll(); 
            int[] ans = packetStore.get(packet);
            packetStore.remove(packet); 

            int dest = ans[1];
            int index = startIndex.get(dest);
            startIndex.put(dest , index + 1);
            return ans;
        }
        return new int[]{};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!destTime.containsKey(destination)) return 0;

        int index = startIndex.get(destination);
        List<Integer> list = destTime.get(destination);
        int idx1 = lowerBound(list , startTime , index);
        int idx2 = upperBound(list , endTime , index);
        
        return idx2 - idx1;
    }
    public int lowerBound(List<Integer> ls , int target , int index){
        int l = index;
        int h = ls.size() - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(ls.get(mid) >= target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    public int upperBound(List<Integer> ls , int target , int index){
        int l = index;
        int h = ls.size() - 1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(ls.get(mid) > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */