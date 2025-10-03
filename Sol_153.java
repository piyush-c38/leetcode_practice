public class Sol_153 {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int k = (nums.length%2 == 0)? (nums.length/2) : ((nums.length/2)+1);

        //comparing start and end of array gives O(log(n)) TmCxty
        for(int i=0; i<k; i++){
            if(nums[i] <= nums[(nums.length-1)-i]){
                if(nums[i]<min) min = nums[i];
            }else{
                if(nums[(nums.length-1)-i]<min) min = nums[(nums.length-1)-i];
            }
        }

        return min;
    }
}
