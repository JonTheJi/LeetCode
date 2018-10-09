class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        HashSet<List<Integer>> container = new HashSet<>();

        int mid;
        int end;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            mid = i + 1;
            end = nums.length - 1;
            while (mid < end) {
                int temp = nums[i] + nums[mid] + nums[end];

                if (temp == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[mid]);
                    l.add(nums[end]);
                    container.add(l);
                    mid++;
                    end--;
                } else if (temp < 0){
                    mid++;
                } else {
                    end--;
                }
            }
        }
        for (List<Integer> traverse : container) {
            result.add(traverse);
        }
        return result;
    }
}
