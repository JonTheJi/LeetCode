class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
