package bigbigbai._00_assignment._00_array.lc1;

public class _66_PlusOne {
    // 取余，判断
    // 非0，没有进位，直接return
    // 0，进位，接着loop
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
