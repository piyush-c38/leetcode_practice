class Sol_26 {
    public static int removeDuplicates(int[] nums) {
        int lastEle = nums[nums.length - 1];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == lastEle) {
                k++;
                return k;
            } else {
                if (nums[i] == nums[i + 1]) {
                    // shifting the remaining elements to left
                    for (int j = i; j < nums.length - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    i--;
                } else {
                    k++; // increamenting the unique length count
                    continue;
                }
            }
        }
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        nums = temp;
        return k;
    }

    public static void main(String args[]) {
        int[] nums = { 1, 1, 2, 3, 3, 4 };
        int[] solution = { 1, 2, 3, 4 };
        int k = removeDuplicates(nums);

        for (int i = 0; i < k; i++) {
            if(nums[i] != solution[i]){
                System.out.println("Test case Failed!");
                return;
            }
        }
        System.out.println("Test case Passed!");
        return;
    }
}