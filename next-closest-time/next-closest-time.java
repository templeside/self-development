class Solution {
    /*
    divide the time, and update with the value by 1.
    increment by 1....
    
    1. get hashset
    2. get hours, i=mins
    split up by the hours, mins
    */
    public String nextClosestTime(String time) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< time.length(); i++){
            if(time.charAt(i) !=':')
                set.add(time.charAt(i)-'0');
        }
        
        int hours = Integer.parseInt(time.substring(0,2));
        int mins= Integer.parseInt(time.substring(3,5));
        
        while(true){
            mins++;
            hours = (hours+ mins/60)%24;
            mins = mins%60;
            
            if(set.contains(hours%10)&& set.contains(hours/10)  &&set.contains(mins%10) &&set.contains(mins/10))
                break;
        }
        return String.format("%02d:%02d",hours,mins);
    }
}