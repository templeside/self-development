class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((a,b)-> (b+a).compareTo(a+b));
        for(int num: nums){
            queue.add(Integer.toString(num));
        }
        StringBuilder sb=  new StringBuilder();
        while(!queue.isEmpty()){
            if(sb.isEmpty() && queue.peek().equals("0")){
                queue.poll();
                continue;
            }
                
            sb.append(queue.poll());
        }
        return sb.isEmpty()? "0":sb.toString();
    }
}