class Solution {
    /*
    starting from the largest number, 
    save as string
    
    sort((a,b)-> starting from the first char. compare which one is bigger.)
    */
    public String largestNumber(int[] nums) {
        String[] stringNums = new String[nums.length];
        
        for(int i=0; i<nums.length; i++){
            stringNums[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(stringNums, (a,b) -> (b+a).compareTo(a+b));
        
        if(stringNums[0].equals("0"))
            return "0";
        StringBuilder sb=  new StringBuilder();
        
        for(String s: stringNums)
            sb.append(s);
        return sb.toString();
    }
}