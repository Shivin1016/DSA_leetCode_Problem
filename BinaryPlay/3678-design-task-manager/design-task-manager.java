class TaskManager { 

    Map<Integer, Integer> taskPriority ; //{taskId -> priority} 
    Map<Integer , Integer> taskUser ;  //{taskId -> userId} 
    PriorityQueue<int[]> pq; //{priority , taskId}

    public TaskManager(List<List<Integer>> tasks) {
        taskPriority = new HashMap<>(); 
        taskUser = new HashMap<>(); 
        pq = new PriorityQueue<>((a , b) -> {
            if(b[0] != a[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        //add in pq 
        for(List<Integer> task : tasks){ 
            add(task.get(0) , task.get(1) , task.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {  
        pq.offer(new int[]{priority , taskId});
        taskPriority.put(taskId , priority);
        taskUser.put(taskId , userId);
    }
    
    public void edit(int taskId, int newPriority) {  
        taskPriority.put(taskId , newPriority);
        pq.offer(new int[] {newPriority , taskId});
    }
    
    public void rmv(int taskId) {  
        taskPriority.put(taskId , -1); //mark as invalid
    }
    
    public int execTop() {   
        
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int taskId = top[1];
            int priority = top[0];
            if(taskPriority.getOrDefault(taskId , -1) == priority){
                //fresh 
                taskPriority.put(taskId , -1); //mark as executed
                return taskUser.get(taskId);
            }
        } 

        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */