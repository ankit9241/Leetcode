class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int maxLength=0;
        int left=0;

        Map<Character, Integer> charMap = new HashMap<>();
        for (int right=0; right<n; right++){
            char currentChar= s.charAt(right);
            if(charMap.containsKey(currentChar)){
                left=Math.max(left, charMap.get(currentChar) +1);
            }
            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}