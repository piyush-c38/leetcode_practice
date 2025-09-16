import java.util.*;

class Sol_2197 {
    public static int findGCD(int a, int b){
        //finding GCD
         while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {
        //converting the nums to num Array
        List<Integer> numArr = new ArrayList<>();
        for(int num: nums){
            numArr.add(num);
        }

        //checking co-prime pairs
        int i = 0;
        while (i < numArr.size() - 1) {
            int a = numArr.get(i);
            int b = numArr.get(i + 1);
            int g = findGCD(a, b);           
            if (g > 1) {
                int l = (int)((long)a / g * b); // safe lcm
                // replace the pair with l
                numArr.remove(i + 1);    // remove right element first
                numArr.set(i, l);        // set merged value at i
                if (i > 0) i--;          // step back to re-check with previous element
            } else {
                i++;
            }
        }

        return numArr;
    }
    public static void main(String args[]){
        int[] nums = {6,4,3,2,7,6,2};
        System.out.println(replaceNonCoprimes(nums));
    }
}