class Solution {
    /**
    permutation...!
    I think i can do with other things.
    this is a permutation for sure... maybe......
    그냥 계속 해서 increment하다가 보면 모든 char이 나올 때가 있다. 그게 바로 next closest time이다.
    
    1. get all of the time values.
    2. increment the time.
    3. if all values are valid, return the value.
    **/
    public String nextClosestTime(String time) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< time.length(); i++){
            if(i != 2)
                set.add(time.charAt(i)-'0');
        }
        
        int hours = Integer.parseInt(time.substring(0,2));
        int mins = Integer.parseInt(time.substring(3,5));
        
        while(true){
            mins ++;
            hours = (hours+ mins/60)%24;
            mins = mins%60;
            
            if(set.contains(hours/10)&&
               set.contains(hours%10)&&
               set.contains(mins/10)&&
               set.contains(mins%10)) break;
        }
        return String.format("%02d:%02d",hours,mins);
    }
}