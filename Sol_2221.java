class Solution_2221 {
    private int calcTriSum(ArrayList<Integer> arr){
        //base case to return the only ele present
        if(arr.size() == 1){
            return arr.get(0);
        }

        //newNums to store the new array
        ArrayList<Integer> newNums = new ArrayList<>();

        for(int i=0; i<arr.size()-1; i++){
            newNums.add((arr.get(i)+arr.get(i+1)) % 10);
        }

        return calcTriSum(newNums);
    }
    public int triangularSum(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        //transfer nums to Arraylist
        for(int ele: nums) arr.add(ele);

        return calcTriSum(arr);
    }
}
