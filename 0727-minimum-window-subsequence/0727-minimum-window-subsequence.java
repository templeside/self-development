class Solution {
    public String minWindow(String str1, String str2) {
        int sizeStr1 = str1.length();
        int sizeStr2 = str2.length();
        float length = Float.POSITIVE_INFINITY;
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0,
        end = 0;
        String minSubsequence = "";
        while (indexS1 < sizeStr1) {
          if (str1.charAt(indexS1) == str2.charAt(indexS2)) {
            indexS2 += 1;
            if (indexS2 == sizeStr2) {
              start = indexS1;
              end = indexS1 + 1;
              indexS2 -= 1;
              while (indexS2 >= 0) {
                if (str1.charAt(start) == str2.charAt(indexS2)) {
                  indexS2 -= 1;
                }
                start -= 1;
              }
              start += 1;
              if ((end - start) < length) {
                length = end - start;
                minSubsequence = str1.substring(start, end);
              }
              indexS1 = start;
              indexS2 = 0;
            }
          }
          indexS1 += 1;
        }
        return minSubsequence;

    }
}