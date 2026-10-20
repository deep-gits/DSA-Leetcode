class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        
        // Insert all numbers into the Trie
        for (int num : nums) {
            TrieNode curr = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new TrieNode();
                }
                curr = curr.children[bit];
            }
        }
        
        int maxLen = 0;
        
        // Find the maximum XOR for each number
        for (int num : nums) {
            TrieNode curr = root;
            int currentXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                // We want the opposite bit to maximize XOR
                int toggledBit = 1 - bit;
                
                if (curr.children[toggledBit] != null) {
                    currentXor |= (1 << i);
                    curr = curr.children[toggledBit];
                } else {
                    curr = curr.children[bit];
                }
            }
            maxLen = Math.max(maxLen, currentXor);
        }
        
        return maxLen;
    }
}