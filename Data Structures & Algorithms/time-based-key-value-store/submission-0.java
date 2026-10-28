class TimeMap {
    private Map<String, List<Pair>> map;

    private static class Pair {
        int time; String value;
        Pair(int t, String v) { time = t; value = v; }
    }

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // get the list for key (create it if missing), then append
        Pair pair = new Pair(timestamp, value);
        map.putIfAbsent(key, new ArrayList<>());
        List<Pair> pairs = map.get(key);
        pairs.add(pair);
        map.put(key, pairs);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);

        String answer = "";
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m).time <= timestamp) {
                answer = list.get(m).value;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return answer;
    }
}