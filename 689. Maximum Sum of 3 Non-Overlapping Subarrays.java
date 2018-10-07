class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int end = nums.length;
        int[] leftPos = new int[end];
        int[] rightPos = new int[end];
        int[] sum = new int[end + 1];

        for (int i = 0; i < end; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
/*
        0  0123 ...
sum   0.. .    k
nums 0 ..k -1   k
*/
        int total = sum[k] - sum[0];
        for (int j = k; j < end; j++) {
            if (total < sum[j + 1] - sum[j + 1 - k]) {
                total = sum[j + 1] - sum[j + 1 - k];
                leftPos[j] = j - k + 1;
            } else {
                leftPos[j] = leftPos[j - 1];
            }
        }

        total = sum[end]  - sum[end - k];
        rightPos[end - k] = end - k;
        for (int r = end - k - 1; r >= 0; r --) {
            if (total <= sum[r + k] -  sum[r] ) {
                total = sum[r + k] - sum[r];
                rightPos[r] = r;
            } else {
                rightPos[r] = rightPos[r + 1];
            }
        }
        int[] result = new int [3];
        int maximum = 0;
        for (int m = k; m <= end - 2 * k; m++) {
            int left = leftPos[m - 1];
            int right =rightPos[m + k];

            int leftSum = sum[left + k] - sum[left];
            int rightSum = sum[right + k] - sum[right];
            int temp = leftSum + rightSum + sum[m + k] - sum[m];

            if (maximum < temp) {
                maximum = temp;
                result[0] = left;
                result[1] = m;
                result[2] = right;
            }
        }
        return result;
    }
}
