class Solution {
    public ArrayList<String> answer;
    public String digits;
    public long target;

    public void recurse(
        int index, long prevOperand, long currOperand, long value, ArrayList<String> ops) {
        String nums = digits;
        // Done processing all the digits in num

        if (index == nums.length()) {
            // If the final value == target expected AND
            // no operand is left unprocessed
            if (value == target && currOperand == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                answer.add(sb.toString());
            }
            return;
        }

        // Extending the current operand by one digit
        currOperand = currOperand * 10 + Character.getNumericValue(nums.charAt(index));
        String current_val_rep = Long.toString(currOperand);
        int length = nums.length();

        // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
        // valid operand. Hence this check
        if (currOperand > 0) {

            // NO OP recursion
            recurse(index + 1, prevOperand, currOperand, value, ops);
        }

        // ADDITION
        ops.add("+");
        ops.add(current_val_rep);
        recurse(index + 1, currOperand, 0, value + currOperand, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0) {
            // SUBTRACTION
            ops.add("-");
            ops.add(current_val_rep);
            recurse(index + 1, -currOperand, 0, value - currOperand, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            // MULTIPLICATION
            ops.add("*");
            ops.add(current_val_rep);
            recurse(index + 1, currOperand * prevOperand, 0, value - prevOperand + (currOperand * prevOperand), ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0)
            return new ArrayList<String>();
        
        this.target = target;
        digits = num;
        answer = new ArrayList<String>();
        recurse(0, 0, 0, 0, new ArrayList<String>());
        return answer;
    }
}

