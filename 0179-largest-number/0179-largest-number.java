class Solution {
    private class StringNumComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String x = a+b;
            String y = b+a;
            return y.compareTo(x);
        }
    }
    public String largestNumber(int[] nums) {
        String[] numsStringArr = new String[nums.length];
        for(int i=0; i< nums.length; i++){
            numsStringArr[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(numsStringArr, new StringNumComparator());
        
        if(numsStringArr[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< nums.length; i++){
            sb.append(numsStringArr[i]);
        }
        return sb.toString();
    }
}