
import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        if (words.length == 0 || s.length() == 0) {
            return ans;
        }

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        if (s.length() < totalLen) {
            return ans;
        }

        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {

            int left = i;
            int count = 0;

            Map<String, Integer> seen = new HashMap<>();

            for (int right = i; right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (freq.containsKey(word)) {

                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > freq.get(word)) {

                        String leftWord = s.substring(left, left + wordLen);

                        seen.put(leftWord, seen.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                    if (count == totalWords) {
                        ans.add(left);

                        String leftWord = s.substring(left, left + wordLen);

                        seen.put(leftWord, seen.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                } else {

                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return ans;
    }
}
