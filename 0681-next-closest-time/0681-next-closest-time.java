class Solution {
    /*
    while incrementation
    do somethings
    
    its always great to have the time in integer.
    
    split the time into integer.
    
    while incrementing,
    mm++
    hh = (hh+mm%60)%24
    mm = mm%60
    check isvalid
    if valid, return.
    */
    public String nextClosestTime(String time) {
        Set<Integer> digit = new HashSet<>();
        String[] tt = time.split(":");
        int hh = Integer.parseInt(tt[0]);
        int mm = Integer.parseInt(tt[1]);
        digit.add(hh/10);
        digit.add(hh%10);
        digit.add(mm/10);
        digit.add(mm%10);
        
        while(true){
            mm++;
            hh = (hh+mm/60)%24;
            mm = mm%60;
            
            if(digit.contains(hh/10)&& digit.contains(hh%10) && digit.contains(mm/10)&& digit.contains(mm%10)){
                break;
            }
        }
        return String.format("%02d:%02d", hh,mm);
    }
}