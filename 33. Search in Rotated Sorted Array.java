class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] index = {-1};
        binarySearch(nums, target, 0, nums.length - 1, index);
        return index[0];
    }
    private void binarySearch(int[] nums, int target, int start, int end, int[] index) {
        int mid = start + (end - start) / 2;
        if (start <= mid && mid <= end && nums[mid] == target) {
            index[0] = mid;
            return;
        }
        if (start <= end) {
            // if the left side is sorted, do BST on the left side if the element is there, else BST the right
            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start]) {
                    binarySearch(nums, target, start, mid - 1, index);
                } else {
                    binarySearch(nums, target, mid + 1, end, index);
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    binarySearch(nums, target, mid + 1, end, index);
                } else {
                    binarySearch(nums, target, start, mid - 1, index);
                }
            }
        }
    }
}
