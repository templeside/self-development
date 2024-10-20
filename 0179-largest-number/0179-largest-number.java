class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strings = new String[n];
        for(int i=0; i< n; i++){
            strings[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strings, (a,b)-> (b+a).compareTo(a+b));
        
        StringBuilder sb = new StringBuilder();
        if(strings[0].equals("0"))
            return "0";
        for(int i=0; i<n; i++){
            sb.append(strings[i]);
        }
        return sb.toString();
    }
}