public class Sol_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; 
            } else if (nums[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return left;
    }
    public static void main(String[] args){

        int[] nums = {1,3,4,5};
        int target = 4;
        int answer = 2;

        Sol_35 obj = new Sol_35();
        int result = obj.searchInsert(nums,target);

        if(result == answer){
            System.out.println("Test case passed!");
        }else{
            System.out.println("Test case failed!");
        }
    }
}