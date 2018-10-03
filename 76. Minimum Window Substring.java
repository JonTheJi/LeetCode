class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 ||
                t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> dictionary = buildDictionary(t);
        int match = dictionary.size();
        int fast = 0;
        int slow = 0;
        int min = Integer.MAX_VALUE;
        String result = "";

        while (fast < s.length()) {
            Character current = s.charAt(fast);
            Integer count = dictionary.get(current);

            if (count != null) {
                dictionary.put(current, count - 1);

                if (count == 1) {
                    match--;
                    if (match == 0) {
                        while (match == 0) {
                            Character back = s.charAt(slow);
                            Integer backCount = dictionary.get(back);
                            int temp = fast + 1 - slow;

                            if (min > temp) {
                                min = temp;
                                result = s.substring(slow, fast + 1);
                            }

                            if (backCount != null) {
                                dictionary.put(back, backCount + 1);

                                if (backCount == 0) {
                                    match++;
                                }
                            }
                            slow++;
                        }
                    }
                }
            }
            fast++;
        }
        return result;
    }
    private HashMap<Character, Integer> buildDictionary(String t) {
        HashMap<Character, Integer> dictionary = new HashMap<>();

        for (Character c : t.toCharArray()) {
            Integer count = dictionary.get(c);
            if (count == null) {
                dictionary.put(c, 1);
            } else {
                dictionary.put(c, count + 1);
            }
        }
        return dictionary;
    }
}
