class Solution {
    public int magic(int curr){
        int sum = 0;
        while(curr>0){
            int num = curr%10;
            sum += num*num;
            curr = curr/10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        int curr = n;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(1);
        
        while(curr>1){
            curr = magic(curr);
            if(visited.contains(curr))
                break;
            
            visited.add(curr);
        }
        System.out.println(curr);
        return curr ==1;
    }
}