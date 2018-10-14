class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        ArrayList<Integer> xR = new ArrayList<>();

        int xCopy = x;
        while (x > 0) {
            int temp = x % 10;
            xR.add(temp);
            x /= 10;
        }

        for (Integer i : xR) {
            x = x * 10 + i;
        }
        return (x == xCopy);
    }
}
