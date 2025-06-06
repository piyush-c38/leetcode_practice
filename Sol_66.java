public class Sol_66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // for digits that less than 9, like 999
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // set the digit to 0 and increase the digit ahead
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String args[]) {
        int[] digits = { 9, 2, 1, 3 };
        int[] result = { 9, 2, 1, 5 };

        Sol_66 obj = new Sol_66();
        obj.plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            if (digits.length != result.length) {
                System.out.println("Test case Failed!");
                return;
            }

            if (digits[i] != result[i]) {
                System.out.print("Test case Failed!");
                return;
            }
        }

        System.out.println("Test case Passed!");
    }
}