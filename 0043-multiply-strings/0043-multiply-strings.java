
class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';

                int mul = d1 * d2;

                int sum = mul + res[i + j + 1];

                res[i + j + 1] = sum % 10;

                res[i + j] += sum / 10;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int digit : res) {
            if (ans.length() == 0 && digit == 0) {
                continue;
            }

            ans.append(digit);
        }

        return ans.toString();
    }
}
