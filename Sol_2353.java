import java.util.*;

class Sol_2353 {

    private String[] foods, cuisines;
    private int[] ratings;

    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, PriorityQueue<FoodEntry>> cuisineToFoods;

    // entry stored in PQ (stores rating at insertion time)
    private static class FoodEntry {
        String name;
        int rating;

        FoodEntry(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    // comparator: higher rating first; tie -> lexicographically smaller name
    private class EntryComparator implements Comparator<FoodEntry> {
        public int compare(FoodEntry a, FoodEntry b) {
            if (a.rating != b.rating)
                return b.rating - a.rating;
            return a.name.compareTo(b.name);
        }
    }

    public Sol_2353(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;

        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
            cuisineToFoods
                    .computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(new EntryComparator()))
                    .add(new FoodEntry(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodToRating.put(food, newRating);
        String cuisine = foodToCuisine.get(food);
        // lazy update: push new entry with updated rating
        cuisineToFoods.get(cuisine).add(new FoodEntry(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodEntry> pq = cuisineToFoods.get(cuisine);

        while (!pq.isEmpty()) {
            FoodEntry top = pq.peek();
            int currentRating = foodToRating.get(top.name);
            if (top.rating == currentRating) {
                return top.name;
            }
            pq.poll(); // stale entry, remove and continue
        }
        return ""; // unreachable for valid input, but safe fallback
    }

    public static void main(String args[]) {
        String[] foods = { "kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi" };
        String[] cuisines = { "korean", "japanese", "japanese", "greek", "japanese", "korean" };
        int[] ratings = { 9, 12, 8, 15, 14, 7 };

        Sol_2353 obj = new Sol_2353(foods, cuisines, ratings);
        obj.changeRating("kimchi", 20);
        String param_2 = obj.highestRated("korean");

        System.out.println(param_2);
    }
}