
class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();

    // Build Trie
    public void insert(String word) {

        TrieNode curr = root;

        for(char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {

        // Insert all words into Trie
        for(String word : words) {
            insert(word);
        }

        List<String> ans = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    public void dfs(char[][] board, int r, int c,
                    TrieNode node, List<String> ans) {

        // Boundary check
        if(r < 0 || c < 0 ||
           r >= board.length || c >= board[0].length ||
           board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];

        int idx = ch - 'a';

        // Character not present in Trie
        if(node.children[idx] == null) {
            return;
        }

        TrieNode next = node.children[idx];

        // Word found
        if(next.word != null) {
            ans.add(next.word);

            // Avoid duplicate answers
            next.word = null;
        }

        // Mark visited
        board[r][c] = '#';

        // Explore four directions
        dfs(board, r + 1, c, next, ans);
        dfs(board, r - 1, c, next, ans);
        dfs(board, r, c + 1, next, ans);
        dfs(board, r, c - 1, next, ans);

        // Backtracking
        board[r][c] = ch;
    }
}
