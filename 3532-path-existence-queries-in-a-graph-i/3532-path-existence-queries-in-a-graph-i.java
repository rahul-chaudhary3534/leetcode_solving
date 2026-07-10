import java.util.*;

class Solution {
    public boolean[] pathExistenceQueries(
        int n,
        int[] nums,
        int maxDiff,
        int[][] queries
    ) {
        // Step 1: Store original indices
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Step 2: Sort indices according to nums values
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        /*
         * component[original node index]
         * = connected component ID of that node
         */
        int[] component = new int[n];

        int componentId = 0;

        // First sorted node belongs to component 0
        component[indices[0]] = componentId;

        // Step 3: Build connected components
        for (int i = 1; i < n; i++) {

            int currentNode = indices[i];
            int previousNode = indices[i - 1];

            // If consecutive sorted values have a large gap,
            // a new connected component starts.
            if ((long) nums[currentNode] - nums[previousNode] > maxDiff) {
                componentId++;
            }

            component[currentNode] = componentId;
        }

        // Step 4: Answer queries
        boolean[] answer = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            answer[i] = component[u] == component[v];
        }

        return answer;
    }
}