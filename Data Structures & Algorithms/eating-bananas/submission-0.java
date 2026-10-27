class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //for each of the piles, we subtract k and increase hours
        //how can we use the most amount of hours? -> more hours = less k
        //how can we use binary search for this.
        /* Piles = [1,4,3,2], h = 9
            k=1 → 10 hours (invalid)
            k=2 → 6 hours (valid)
            k=3 → 5 hours (valid)
            k=4 → 4 hours (valid)
            k=5 -> 4 hours(valid)
            k=6 -> 4 hours(valid)
            ....
            k=1000->still 4 hours required(valid)
        */
        //do a bs on 1 - max(piles)
        //increment mid when hours > h
        //decrement otherwise
        int l = 1, r = 0;
        for (int p : piles) r = Math.max(r, p);

        int answer = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (hoursNeeded(piles, m) <= h) {
                answer = m;      // m works, so save it...
                r = m - 1;       // ...but try to find a slower speed that works
            } else {
                l = m + 1;       // too slow, need to eat faster
            }
        }
        return answer;
    }
    private long hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k;   // ceil(p / k) using integer math
        }
        return hours;
    }
}
