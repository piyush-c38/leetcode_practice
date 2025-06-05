public class Sol_27 {
    class Solution {
        public static int removeElement(int[] nums, int val) {
            int k = 0;
            int[] cpArray = new int[nums.length];

            // copy all the non val elements to new cpArray
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    continue;
                } else {
                    cpArray[k] = nums[i];
                    k++;
                }
            }

            // copy the cpArray to nums array accordingly
            for (int i = 0; i < k; i++) {
                nums[i] = cpArray[i];
            }

            return k;
        }

        // simple insertion sort for the first k elements
        public static void sort(int[] nums, int start, int end) {
            for (int i = start + 1; i < end; i++) {
                int key = nums[i];
                int j = i - 1;
                while (j >= start && nums[j] > key) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = key;
            }
        }

        //main method
        public static void main(String[] args) {
            int[] nums = { 3, 2, 2, 3 }; 
            int val = 2;
            int[] expectedNums = { 3, 3 };

            int k = removeElement(nums, val);

            if(k != expectedNums.length){
                System.out.println("Test case failed!");
                return;
            }

            sort(nums, 0, k); 
            for (int i = 0; i < k; i++) {
                if(nums[i] != expectedNums[i]){
                    System.out.println("Test case failed!");
                    return;
                }
            }
            System.out.println("Test case passed!");
        }
    }
}
