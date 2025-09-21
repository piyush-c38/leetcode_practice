class MovieRentingSystem {
    private static class Entry {
        int shop, movie, price;
        Entry(int s, int m, int p) {
            shop = s; movie = m; price = p;
        }
    }

    // Lookup for price
    private Map<String, Integer> priceMap = new HashMap<>();
    // movie -> available shops
    private Map<Integer, TreeSet<Entry>> available = new HashMap<>();
    // rented movies (global)
    private TreeSet<Entry> rented = new TreeSet<>( (a, b) -> {
        if (a.price != b.price) return a.price - b.price;
        if (a.shop != b.shop) return a.shop - b.shop;
        return a.movie - b.movie;
    });

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Entry entry = new Entry(shop, movie, price);

            priceMap.put(shop + "#" + movie, price);
            available.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a.price != b.price) return a.price - b.price;
                return a.shop - b.shop;
            })).add(entry);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        int count = 0;
        for (Entry e : available.get(movie)) {
            res.add(e.shop);
            if (++count == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        Entry entry = new Entry(shop, movie, price);
        available.get(movie).remove(entry);
        rented.add(entry);
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        Entry entry = new Entry(shop, movie, price);
        rented.remove(entry);
        available.get(movie).add(entry);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (Entry e : rented) {
            res.add(Arrays.asList(e.shop, e.movie));
            if (++count == 5) break;
        }
        return res;
    }
}
