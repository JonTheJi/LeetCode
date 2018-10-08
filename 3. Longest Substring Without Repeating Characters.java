class Solution {
    public int lengthOfLongestSubstring(String s) {
        int fast = 0;
        int slow = 0;
        int max = 0;
        HashMap<Character, Boolean> found = new HashMap<>();
        while (fast < s.length()) {
            Character current = s.charAt(fast);
            Boolean contain = found.get(current);
            if (contain == null) {
                found.put(current, true);
                fast++;
            } else {
                while (slow < fast) {
                    Character back = s.charAt(slow);
                    if (back == current) {
                        slow++;
                        found.remove(back);
                        break;
                    } else {
                        slow++;
                    }
                }
            }
            max = (max < fast - slow) ？fast - slow : max;
        }
        return max;
    }
}class Solution {
    public int lengthOfLongestSubstring(String s) {
        int fast = 0;
        int slow = 0;
        int max = 0;
        HashMap<Character, Boolean> found = new HashMap<>();
        while (fast < s.length()) {
            Character current = s.charAt(fast);
            Boolean contain = found.get(current);
            if (contain == null) {
                found.put(current, true);
                fast++;
            } else {
                while (slow < fast) {
                    Character back = s.charAt(slow);
                    found.remove(back);
                    if (back == current) {
                        slow++;
                        break;
                    } else {
                        slow++;
                    }
                }
            }
            max = (max < fast - slow) ? fast - slow : max;
        }
        return max;
    }
}
