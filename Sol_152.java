public class Sol_152 {
    public int maxProduct(int[] nums) {
        //traverse through nums
        int product=1, maxProduct = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            //make subarrays fixing the current ele
            product = nums[i];
            if(product>maxProduct) maxProduct = product;

            for(int j=i+1; j<nums.length; j++){
                product *= nums[j];
                if(product>maxProduct) maxProduct = product;
            }
        }

        return maxProduct;
    }
}
