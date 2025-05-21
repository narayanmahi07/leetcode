class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int mincap =0;
        int maxcap = 0;
        for(int weight:weights){
            mincap = Math.max(mincap, weight);
            maxcap += weight;
        }

        while (mincap < maxcap){
            int mid = mincap + (maxcap - mincap)/2;

            int days = 1;
            int sum = 0;
            for(int weight :weights) {
                if (sum + weight > mid) {
                    days++;
                    sum = 0;
                }
                sum += weight;
            }
            if (days > D){
                mincap = mid +1;
            }
            else{
                maxcap = mid;
            }
        }
        return mincap;
    }
}