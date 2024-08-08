class Solution {
    /*
    calculate all the strings
    count the number
    if the max is bigger than half, return ""   n+1/2 > maxcount
    
    while out of all chars
        shifting index, adding chars
        max, next max
        
s= aab
a-2
b-1

max: a,2
queue: b,1
    */
    public String reorganizeString(String s) {
//         calculate all the strings
        Map<Character, Integer> map = new HashMap<>();
//         count the number
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue= new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            queue.add(entry);
        }

//         if the max is bigger than half, return ""   n+1/2 > maxcount
        if(queue.peek().getValue() > (s.length()+1)/2)
            return "";
        
        Map.Entry<Character, Integer> curr = queue.poll();
        char currChar = curr.getKey();
        int currCount = curr.getValue();
        
        char[] returnVal = new char[s.length()];
        //even first
        for(int i=0; i< s.length(); i=i+2){
            returnVal[i] = currChar;
            currCount--;
            if(currCount ==0 && !queue.isEmpty()){
                curr = queue.poll();
                currChar = curr.getKey();
                currCount = curr.getValue();
            }
        }
        //odd second
        for(int i=1; i< s.length(); i=i+2){
            returnVal[i] = currChar;
            currCount--;
            if(currCount ==0 && !queue.isEmpty()){
                curr = queue.poll();
                currChar = curr.getKey();
                currCount = curr.getValue();
            }
        }
        return new String(returnVal);
    }
}