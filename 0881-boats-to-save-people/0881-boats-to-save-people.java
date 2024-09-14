class Solution {
    /*
    do greedy idea.
    sort the people
    matching people light and 
    
        [1,2]
left     ^
right      ^
    */
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int count = 0;
        
        while(left<=right){
            int remainder = limit-people[right];
            if(left<= right && remainder>= people[left]){
                left++;
            }
            right--;
            count++;
        }
        return count;
    }
}