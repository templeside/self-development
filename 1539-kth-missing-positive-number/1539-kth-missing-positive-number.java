class Solution {
    public static void swap(int[] nums,int  i,int  j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  
  public static int findKthPositive(int[] nums, int k) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1);
      else
        i++;
    }

    List<Integer> missingNumbers = new ArrayList<>();
    Set<Integer> extraNumbers = new HashSet<>();
    for (i = 0; i < nums.length && missingNumbers.size() < k; i++)
      if (nums[i] != i + 1) {
        missingNumbers.add(i + 1);
        extraNumbers.add(nums[i]);
      }

    // add the remaining missing numbers
    for (i = 1; missingNumbers.size() < k; i++) {
      int candidateNumber = i + nums.length;
      // ignore if the array contains the candidate number
      if (!extraNumbers.contains(candidateNumber))
        missingNumbers.add(candidateNumber);
    }

    return missingNumbers.get(missingNumbers.size()-1);
  }
}