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
// Dynamic programming O(n) space complexity
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // init the array for DP
        int len = s.length();
        int[] dp = new int[len + 1];
        // base case
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= len; i++) {
            int first = s.charAt(i - 1) - '0';
            int total = first+ (s.charAt(i - 2) - '0') * 10;

            if (first > 0 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (total <= 26 && total >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
// Dynamic programming O(n) space complexity


  1 2 3
0 1 2 3
1

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // base case
        int c1 = 1;
        int c2 = 1;

        for (int i = 1; i  <= s.length() - 1; i++) {
            int first = s.charAt(i) - '0';
            int total = first + (s.charAt(i - 1) - '0') * 10;

            if (first == 0) {
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
