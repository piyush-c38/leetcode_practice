public class Sol_1 {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length-1; i++){

            for(int j = i+1; j<nums.length; j++){

                if((nums[i] + nums[j]) == target){
                    int[] result = {i,j};
                    return result;
                }
            }
        }
        int result[] = {};
        return result;
    }

    public static void main(String args[]){
        int[] nums = {1,2,3};
        int[] result = twoSum(nums,5);
        int[] solution = {1,2};

        //checkiing the test case
        for(int i = 0; i<result.length; i++){
            if(solution[i] != result[i]){
                System.out.println("Test case Failed");
                return;
            }
        }
        System.out.println("Test case passed");
        return;
    }
}
