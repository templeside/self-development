class Solution {
    public double angleClock(int hour, int minutes) {
        // clocks are the subtraction between hours angle and minutest angle.
        int oneMinAngle = 360/60;
        int oneHourAngle = 360/12;
        
        
        
        double minutesAngle = minutes * oneMinAngle;
        double hoursAngle = oneHourAngle * (hour%12) + oneHourAngle * (minutes/60.0);
        
        double sum = Math.abs(minutesAngle- hoursAngle);
        
        return Math.min(sum, 360-sum);
    }
}