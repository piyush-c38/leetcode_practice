public class Sol_33 {
    public int search(int[] nums, int target) {
        int k = (nums.length%2 == 0) ? (nums.length/2) : ((nums.length/2)+1);

        for(int i=0; i<k; i++){
            if(nums[i] == target) return i;
            if(nums[nums.length-1-i] == target) return nums.length-1-i;
        }

        return -1;
    }
}
