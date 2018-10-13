class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
      HashSet<String> bannedSet = new HashSet<>();

      for (String s : banned) {
        bannedSet.add(s);
      }
      String[] sArray = paragraph.replaceAll("\\W+", " ").toLowerCase().
      split("\\s+");

      HashMap<String, Integer> hm = new HashMap<>();
      for (String s2 : sArray) {
        if (!bannedSet.contains(s2)) {
          Integer count = hm.get(s2);

          if (count == null) {
            hm.put(s2, 1);
          } else {
            hm.put(s2, count + 1);
          }
        }
      }

      int max = 0;
      String result = "";
      for (Map.Entry<String, Integer> en : hm.entrySet()) {
        if (max < en.getValue()) {
          max = en.getValue();
          result = en.getKey();
        }
      }
      return result;
    }
}
