class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] result = {-1};
        binarySearch(nums, 0, nums.length - 1, target, result);
        return result[0];
    }
    private void binarySearch(int[] nums, int start, int end, int target, int[] result) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                return;
            } else {
                // which side ? first check which side is sorted, lets check the left side of the mid fst
                if (nums[mid] > nums[end]) { // for binarySearch -> start will be the fst possible index that == mid
                    if (nums[start] <= target && target < nums[mid]) { // use end to determine sorted side is better 
                        binarySearch(nums, start, mid - 1, target, result);
                    } else {
                        binarySearch(nums, mid + 1, end, target, result);
                    }
                } else {
                    if (nums[mid] < target && target <= nums[end]) {
                        binarySearch(nums, mid + 1, end, target, result);
                    } else {
                        binarySearch(nums, start, mid - 1, target, result);
                    }
                }
            }
        }
    }
}
