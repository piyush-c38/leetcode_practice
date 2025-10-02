public class Sol_3100 {
     public int drink(int full, int empty, int exRate, int drunk){
        //base case
        if(full == 0 && empty<exRate){
            return drunk;
        }

        //drinking
        if(full > 0){
            drunk += full;
        }

        //update empty bottles
        empty += full;
        full=0;

        //get new full bottles
        while(empty/exRate >= 1){
            empty -= exRate;
            full++;
            exRate++;
        }
        
        return drink(full, empty, exRate, drunk);
    }
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        return drink(numBottles, 0, numExchange, 0);
    }
}
