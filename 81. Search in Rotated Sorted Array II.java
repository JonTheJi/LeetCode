/* O(n) runtime -> dont know which sidoe to go for BST, since 11111 -> left and right re both soreted(kinda)?
 * remember to use either this or this for BS searching condition because nums[mid] would naturally == nums[start]
 * when nums.length < 3
 * since you use either or => you know what your nums[mid] equals to, simply remove it by moving the index
*/
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[end]) {    // right side is sorted
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[end]) { // left side is sorted
                if (nums[mid] > target && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {  // if sorted part is unknow and nums[end] = nums[mid] -> end-- to remove duplication
                end--;
            }
        }
        return false;
    }
}
