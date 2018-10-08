class Solution {
    public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            HashMap<Integer, Integer> pre = new HashMap<>();
            pre.put(nums[0], 0);
            for (int i = 1; i < nums.length; i++) {
                int sub = target - nums[i];
                Integer in = pre.get(sub);
                if (in == null) {
                    pre.put(nums[i], i);
                } else {
                    result[0] = in;
                    result[1] = i;
                }
            }
            return result;
    }
}
