class Solution {
    public List<String> restoreIpAddresses(String s) {
            List<String> addresses = new ArrayList<>();
    List<String> currAddress = new ArrayList<>();
    backtrack(0, currAddress, s, addresses);
    // Replace this placeholder return statement with your code
    return addresses;
  }
  public static void backtrack(int startIdx, List<String> currAddress, String s, List<String> addresses){
    if(currAddress.size() == 4){
      if(startIdx == s.length())
        addresses.add(String.join(".", currAddress));
      return;
    }
    for(int endIdx=startIdx; endIdx< s.length() && endIdx<startIdx+3; endIdx++ ){
      String currString = s.substring(startIdx, endIdx+1);
      int currInt = Integer.parseInt(currString);
      if(!currString.equals(""+currInt) || currInt<0 || currInt>255){
        continue;
      }

      currAddress.add(currString);
      backtrack(endIdx+1, currAddress, s, addresses);
      currAddress.remove(currAddress.size()-1);
      
    }
  }

    
}