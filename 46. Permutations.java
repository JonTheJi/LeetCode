class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(result, 0, temp, nums, used);
        return result;
    }
    private void backtracking(List<List<Integer>> result, int start, List<Integer> temp, int[] nums, boolean[] used){
        if (start >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                temp.add(nums[i]);
                used[i] = true;
                backtracking(result, start + 1, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
