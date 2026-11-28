
import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {

            int gray = i ^ (i >> 1);

            result.add(gray);
        }

        return result;
    }
}
