/* remember to use either this or this for BS searching condition because nums[mid] would naturally == nums[start]
 * when nums.length < 3
 * since you use either or => you know what your nums[mid] equals to, simply remove it by moving the index
*/
public boolean search(int[] nums, int target) {
        class Solution {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid <= nums.length  - 1 && mid >= 0 && nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[end]) {
                if (nums[mid] > target && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end--;
            }
        }
        return false;
    }
}
