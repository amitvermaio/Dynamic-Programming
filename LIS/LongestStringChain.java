package DP.LIS;

public class LongestStringChain {
  public static void main(String[] args) {
    
  }
}

class Solution {
    public int longestStrChain(String[] words) {
        // Like - LIS
        int n = words.length;
        HashMap<String, Integer> mp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        for (String word : words) {
            int longestChain = 1;
            
            // Try removing each character to find predecessors
            for (int j = 0; j < word.length(); j++) {
                String predecessor = word.substring(0, j) + word.substring(j + 1);
                
                if (mp.containsKey(predecessor)) {
                    longestChain = Math.max(longestChain, mp.get(predecessor) + 1);
                }
            }
            
            mp.put(word, longestChain);
        }
        
        // Find the longest chain by traversing the map
        int result = 1;
        for (int chainLength : mp.values()) {
            result = Math.max(result, chainLength);
        }
        
        return result;
    }
}
