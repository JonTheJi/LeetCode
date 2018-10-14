class Solution {
    private String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String temp = "";
        helper(result, digits, 0, temp);

        return result;
    }
    private void helper(List<String> result, String digits, int index,String temp) {
        if (temp.length() == digits.length()) {
            result.add(temp);
            return;
        }
        int current = digits.charAt(index) - '0';
        for (int i = 0; i < key[current].length(); i++) {
            char keyChar = key[current].charAt(i);
            helper(result, digits, index + 1, temp + keyChar);
        }
    }
}
