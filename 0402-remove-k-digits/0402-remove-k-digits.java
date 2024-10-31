class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();

        if (n == k) return "0";

        Stack<Integer> stack = new Stack<>();

        for (char ch : num.toCharArray()) {
            int digit = ch - 48; // Because '0' = 48
            if (stack.isEmpty() || stack.peek() <= digit || k == 0) {
                stack.push(digit);
            } else {                
                while (!stack.isEmpty() && digit < stack.peek() && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(digit);
            }
        }

        // if num is in increasing order, then become as it is. so
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        int i = result.length()-1;
        while (i >= 0 && result.charAt(i) - 48 == 0) {
            result.deleteCharAt(i);
            i--;
        }

        return result.length() == 0 ? "0" : result.reverse().toString();
    }
}