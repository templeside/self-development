class Solution {
/**
지금까지는 binary 개수의 dfs, bfs 였지만, 이제는 multi depth first search 이다. 
단순히 variable이 빠지거나 바뀌는 것이 아닌, 가짓수가 여러가지.

그래서 그 전에는 그저 넣는지 안 넣는지 두가지만 recursion을 했지만, 이제는 forloop으로 recursion을 calling 한다.
currently 
                                [2*3-4*5]
        [2]*[3-4*5]         | [2*3]-[4*5] |         [2*3-4]*[5] 
[2]*[3]-[4*5] |[2]*[3-4]*[5]| [2*3]-[4*5] | [2]*[3-4]*[5] |[2]*[3]-[4*5] 
**/
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        // base case: if the input string is a number, parse and add it to output.
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } 
        else {
            for (int i = 0; i < input.length(); i++) {
                char chr = input.charAt(i);
                if (!Character.isDigit(chr)) {
                    // break the equation here into two parts and make recursively calls
                    List<Integer> leftParts = diffWaysToCompute(input.substring(0, i));
                    List<Integer> rightParts = diffWaysToCompute(input.substring(i + 1));
                    for (int part1 : leftParts) {
                        for (int part2 : rightParts) {
                            if (chr == '+')
                                result.add(part1 + part2);
                            else if (chr == '-')
                                result.add(part1 - part2);
                            else if (chr == '*')
                                result.add(part1 * part2);
                        }
                    }
                }
            }
        }
        return result;
    }
}