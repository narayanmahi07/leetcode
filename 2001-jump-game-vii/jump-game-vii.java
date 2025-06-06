public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int farthest = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();

            for (int j = Math.max(i + minJump, farthest + 1); j <= Math.min(i + maxJump, n - 1); j++) {
                if (s.charAt(j) == '0') {
                    if (j == n - 1) return true;
                    queue.offer(j);
                }
            }
            farthest = i + maxJump;
        }

        return false;
    }
}
