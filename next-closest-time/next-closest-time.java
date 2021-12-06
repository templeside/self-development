class Solution {
//     1. store the given digits
//     2. HH:MM -> total MM(int)
//     3. find the next available time checking with 1.
//     4. convert integer to string.
        
//     given= 19:34
//     changedInteger = 01*60+34 = 94
//                                 95, 96, 97, 98, 99
    public String nextClosestTime(String time) {
        int hours = Integer.parseInt(time.substring(0,2));
        int minutes = Integer.parseInt(time.substring(3,5));
        int totalMinutes = hours*60 + minutes;
        
        Set<Integer> timeDigits = new HashSet<Integer>();
        timeDigits.add(hours/10);
        timeDigits.add(hours%10);
        timeDigits.add(minutes/10);
        timeDigits.add(minutes%10);
        
        boolean found = false;
        while(!found){
            totalMinutes  = (totalMinutes +1) %(24*60);
            
            found = true;
            // if(only found does not contains)
            //     notvalid
            for(int digit : new int[]{totalMinutes/60/10,totalMinutes/60%10,totalMinutes%60/10,totalMinutes%60%10}){
                if(!timeDigits.contains(digit))
                    found = false;
            }
            
        }
        hours = totalMinutes/60;
        minutes = totalMinutes%60;
        
        
        return String.format("%02d:%02d", hours, minutes);
    }
}