class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();

        int n = words.length;
        int i = 0;

        while (i < n) {

            int j = i;
            int letters = 0;

            // Find maximum words that can fit in this line
            while (j < n &&
                   letters + words[j].length() + (j - i) <= maxWidth) {

                letters += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            // Last line OR only one word
            if (j == n || gaps == 0) {

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);

                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }

                // Add remaining spaces at the end
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

            } else {

                // Total spaces available
                int totalSpaces = maxWidth - letters;

                // Minimum spaces per gap
                int spaces = totalSpaces / gaps;

                // Extra spaces
                int extra = totalSpaces % gaps;

                for (int k = i; k < j - 1; k++) {

                    sb.append(words[k]);

                    int spaceCount = spaces;

                    // Extra spaces go to leftmost gaps
                    if (k - i < extra) {
                        spaceCount++;
                    }

                    for (int x = 0; x < spaceCount; x++) {
                        sb.append(" ");
                    }
                }

                sb.append(words[j - 1]);
            }

            ans.add(sb.toString());

            i = j;
        }

        return ans;
    }
}