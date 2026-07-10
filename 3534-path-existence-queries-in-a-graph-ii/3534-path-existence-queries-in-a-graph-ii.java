import java.util.*;

class Solution {
    public int[] pathExistenceQueries(
        int n,
        int[] nums,
        int maxDiff,
        int[][] queries
    ) {
        // ------------------------------------------------
        // STEP 1: Sort nodes according to nums[i]
        // ------------------------------------------------

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        // values[i] = value at sorted position i
        int[] values = new int[n];

        // pos[originalIndex] = position in sorted array
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = nums[indices[i]];
            pos[indices[i]] = i;
        }


        // ------------------------------------------------
        // STEP 2: Find farthest position reachable
        //         from each index in ONE edge
        // ------------------------------------------------

        int[] next = new int[n];

        int right = 0;

        for (int left = 0; left < n; left++) {

            if (right < left) {
                right = left;
            }

            while (
                right + 1 < n &&
                (long) values[right + 1] - values[left] <= maxDiff
            ) {
                right++;
            }

            next[left] = right;
        }


        // ------------------------------------------------
        // STEP 3: Find connected components
        // ------------------------------------------------

        /*
         * In sorted order, a new connected component starts
         * whenever:
         *
         * values[i] - values[i - 1] > maxDiff
         */

        int[] component = new int[n];

        int componentId = 0;
        component[0] = componentId;

        for (int i = 1; i < n; i++) {

            if ((long) values[i] - values[i - 1] > maxDiff) {
                componentId++;
            }

            component[i] = componentId;
        }


        // ------------------------------------------------
        // STEP 4: Build Binary Lifting table
        // ------------------------------------------------

        int LOG = 1;

        while ((1L << LOG) <= n) {
            LOG++;
        }

        int[][] jump = new int[LOG][n];

        // jump[0][i] = farthest reachable position
        // using exactly one edge
        for (int i = 0; i < n; i++) {
            jump[0][i] = next[i];
        }

        /*
         * jump[k][i]
         *
         * = farthest position reachable from i
         *   after at most 2^k greedy jumps
         */

        for (int k = 1; k < LOG; k++) {

            for (int i = 0; i < n; i++) {

                jump[k][i] =
                    jump[k - 1][jump[k - 1][i]];
            }
        }


        // ------------------------------------------------
        // STEP 5: Answer every query
        // ------------------------------------------------

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int u = pos[queries[q][0]];
            int v = pos[queries[q][1]];


            // Same node
            if (u == v) {
                answer[q] = 0;
                continue;
            }


            // Always move from left to right
            if (u > v) {

                int temp = u;
                u = v;
                v = temp;
            }


            // Different components -> impossible
            if (component[u] != component[v]) {
                answer[q] = -1;
                continue;
            }


            // --------------------------------------------
            // Find minimum number of jumps
            // --------------------------------------------

            int current = u;
            int steps = 0;

            /*
             * Take the largest jump that keeps us
             * strictly before target v.
             */

            for (int k = LOG - 1; k >= 0; k--) {

                int destination = jump[k][current];

                if (destination < v) {

                    current = destination;
                    steps += (1 << k);
                }
            }


            /*
             * One final jump reaches v or beyond.
             */

            answer[q] = steps + 1;
        }

        return answer;
    }
}