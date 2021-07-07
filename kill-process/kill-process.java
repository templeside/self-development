class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // <ppid, pid>
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i< pid.size();i++){
            int parent = ppid.get(i);
            int curr = pid.get(i);
            
            if(!map.containsKey(parent))
                map.put(parent, new ArrayList<Integer>());
            map.get(parent).add(curr);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int num = q.poll();
            ans.add(num);
            
            if(map.containsKey(num)){
                for(int n: map.get(num))
                    q.add(n);
            }
        }
        return ans;
    }
}