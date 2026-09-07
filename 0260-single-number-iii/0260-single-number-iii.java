class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        long diff = (long) xor & -(long) xor;

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & diff) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}