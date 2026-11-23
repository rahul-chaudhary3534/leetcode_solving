
class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        int fact = 1;

        // Store numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Calculate (n-1)!
        for (int i = 1; i < n; i++) {
            fact *= i;
        }

        // Convert k to 0-based indexing
        k--;

        StringBuilder ans = new StringBuilder();

        while (true) {

            int index = k / fact;

            ans.append(numbers.get(index));
            numbers.remove(index);

            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans.toString();
    }
}
