class Router {
    int[][] router;
    int memoryLimit;
    int firstIdx;
    int lastIdx;

    Set<String> seen; // for duplicate detection
    Map<Integer, TreeMap<Integer, Integer>> prefixMap; // destination -> prefix sums

    public Router(int memoryLimit) {
        router = new int[memoryLimit][3];
        firstIdx = -1;
        lastIdx = -1;
        this.memoryLimit = memoryLimit;

        seen = new HashSet<>();
        prefixMap = new HashMap<>();
    }

    private String key(int s, int d, int t) {
        return s + "#" + d + "#" + t;
    }

    // get prefix sum up to time
    private int getPrefix(TreeMap<Integer, Integer> tm, int time) {
        Map.Entry<Integer, Integer> e = tm.floorEntry(time);
        return (e == null ? 0 : e.getValue());
    }

    private void addToPrefix(int dest, int time, int delta) {
        prefixMap.putIfAbsent(dest, new TreeMap<>());
        TreeMap<Integer, Integer> tm = prefixMap.get(dest);

        // find current prefix up to this time
        int prev = getPrefix(tm, time);
        int newVal = prev + delta;

        // update this timestamp
        tm.put(time, newVal);

        for (var e = tm.higherEntry(time); e != null; e = tm.higherEntry(e.getKey())) {
            tm.put(e.getKey(), e.getValue() + delta);
        }
    }

    public boolean isFull() {
        return ((lastIdx + 1) % memoryLimit) == firstIdx;
    }

    public boolean isEmpty() {
        return (lastIdx == -1);
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String k = key(source, destination, timestamp);
        if (seen.contains(k)) return false; // duplicate

        if (isFull()) {
            int oldS = router[firstIdx][0];
            int oldD = router[firstIdx][1];
            int oldT = router[firstIdx][2];
            seen.remove(key(oldS, oldD, oldT));

            addToPrefix(oldD, oldT, -1); // decrement count

            router[firstIdx][0] = 0;
            router[firstIdx][1] = 0;
            router[firstIdx][2] = 0;
            firstIdx = (firstIdx + 1) % memoryLimit;
        }

        // Insert new packet
        if (isEmpty()) {
            firstIdx = 0;
            lastIdx = 0;
        } else {
            lastIdx = (lastIdx + 1) % memoryLimit;
        }

        router[lastIdx][0] = source;
        router[lastIdx][1] = destination;
        router[lastIdx][2] = timestamp;

        seen.add(k);

        addToPrefix(destination, timestamp, +1); // increment count
        return true;
    }

    public int[] forwardPacket() {
        if (isEmpty()) return new int[0];

        int s = router[firstIdx][0];
        int d = router[firstIdx][1];
        int t = router[firstIdx][2];

        seen.remove(key(s, d, t));

        addToPrefix(d, t, -1); // decrement count

        int[] temp = {s, d, t};

        router[firstIdx][0] = 0;
        router[firstIdx][1] = 0;
        router[firstIdx][2] = 0;

        if (firstIdx == lastIdx) {
            firstIdx = -1;
            lastIdx = -1;
        } else {
            firstIdx = (firstIdx + 1) % memoryLimit;
        }

        return temp;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!prefixMap.containsKey(destination)) return 0;
        TreeMap<Integer, Integer> tm = prefixMap.get(destination);

        return getPrefix(tm, endTime) - getPrefix(tm, startTime - 1);
    }
}
