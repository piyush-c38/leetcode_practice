class Solution_1518 {
    public int drink(int full, int empty, int exRate, int sum){
        //base case
        if(full == 0 && empty<exRate){
            return sum;
        }

        //drinking
        if(full > 0){
            sum += full;
        }

        //update empty bottles
        empty += full;

        //get new full bottles
        full = empty/exRate;
        empty = empty%exRate;
        
        return drink(full, empty, exRate, sum);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        return drink(numBottles, 0, numExchange, 0);
    }
}