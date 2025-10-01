import java.util.Arrays;

class Solution_976 {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int i = nums.length-1; i>=2; i--){
            int a = nums[i-2], b = nums[i-1], c = nums[i];

            //inequality check
            if(a+b > c){
                // if a+b>c, area will automatically be > 0
                return a + b + c;
            }
        }

        return 0;
    }
}
