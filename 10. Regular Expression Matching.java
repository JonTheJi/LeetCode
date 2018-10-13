class Solution {
    public boolean isMatch(String s, String p) {
      if (s == null || p == null) {
        return false;
      }
      boolean[][] d = new boolean[s.length() + 1][p.length() + 1];
      // intit
      // a* -> remove a
      d[0][0] = true;
      for (int i = 1; i < d[0].length; i++) {     // here is important. Make sure that it is d[0].length
        if (p.charAt(i - 1) == '*') {
          d[0][i] = d[0][i - 2];
        }
      }

      for (int si = 1; si <= s.length(); si++) {
        for (int pi = 1; pi <= p.length(); pi++) {
          if (p.charAt(pi - 1) == s.charAt(si - 1) || p.charAt(pi - 1) == '.') {
            d[si][pi] = d[si - 1][pi - 1];
          } else if (p.charAt(pi - 1) == '*') {
            if (p.charAt(pi - 2) == s.charAt(si - 1) || p.charAt(pi - 2) == '.') {
              d[si][pi] = d[si - 1][pi] || d[si][pi - 1] || d[si][pi - 2];
            } else {
              d[si][pi] = d[si][pi - 2];
            }
          }
        }
      }
      return d[s.length()][p.length()];
      /*     1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
             2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                             dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
      */
    }
}
