class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (current == '(') {
                stack.addFirst(')');
            } else if (current == '[') {
                stack.addFirst(']');
            } else if (current == '{') {
                stack.addFirst('}');
            } else {
                // meeting right parenthesis
                if (stack.isEmpty() || current != stack.pop()) {
                    return false;
                }
            }
        }
        // making sure that the right parenthesis has canceld all the left parenthesis
        return (stack.isEmpty()) ? true : false;
    }
}
