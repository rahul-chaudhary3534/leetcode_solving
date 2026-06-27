import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put((long) num, count.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (count.containsKey(1L)) {
            int ones = count.get(1L);
            ans = ones % 2 == 1 ? ones : ones - 1;
            count.remove(1L);
        }

        for (long start : count.keySet()) {
            long x = start;
            int len = 0;

            while (count.getOrDefault(x, 0) >= 2) {
                len += 2;
                x = x * x;
            }

            if (count.getOrDefault(x, 0) >= 1)
                len += 1;
            else
                len -= 1;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}