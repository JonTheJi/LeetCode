// Back-tracking
class Solution {
    public int numDecodings(String s) {
        // what should be returned when s starting with '0' and s == null || s.length() == 0
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = {0};
        decode(s, 0, s.length(), count);
        return count[0];
    }
    private void decode(String s, int index, int end, int[] count) {
        if (index == end) {
            count[0] += 1;
            return;
        }
        int first = s.charAt(index) - '0';
        if (first <= 9 && first > 0) {
            decode(s, index + 1, end, count);
        }
        if (index + 1 < end) {
            int total = first * 10 + (s.charAt(index + 1) - '0');
            if (total >= 10 && total <= 26) {
                decode(s, index + 2, end, count);
            }
        }
    }
}
  012
  123
0 123
1 1
// Dynamic programming O(n) space complexity top-> bottom
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        int index = 0;
        return decode(s.toCharArray(), index, memo);
    }
    private int decode (char[] s, int level, int[] memo) {
        if (memo[level] != -1) {
            return memo[level];
        }
        // base case
        if (level == s.length) {
            memo[level] = 1;
            return memo[level];
        }
        int ways = 0;
        if (s[level] != '0') {
            ways += decode(s, level + 1, memo);
        }
        if (validEncoding(s, level)) {
            ways += decode(s, level + 2, memo);
        }
        memo[level] = ways;
        return ways;
    }
    private boolean validEncoding(char[] array, int start) {
        if (start + 1 >= array.length) {
            return false;
        }
        if (array[start] == '1') {
            return true;
        }
        if (array[start] == '2' && array[start  + 1] - '0' <= 6) {
            return true;
        }
        return false;
    }
}

// Dynamic programming O(n) space complexity top-> bottom
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int first = s.charAt(i - 1) - '0';
            int second = s.charAt(i - 2) - '0';
            int total = first + second * 10;

            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            // 10 -> return 1
            if (total >= 10 && total <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}

// Dynamic programming O(1) space
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int c1 = 1;
        int c2 = 1;

        for (int i = 1; i < s.length(); i++) {
            int first = s.charAt(i) - '0';
            int second = s.charAt(i - 1) - '0';
            int total = first + second * 10;

            if (s.charAt(i) == '0') {
                c1 = 0;
            }
            if (total >= 10 && total <= 26) {
                c1 = c1 + c2;
                c2 = c1 - c2;
            } else {
                c2 = c1;
            }
        }
        return c1;
    }
}
