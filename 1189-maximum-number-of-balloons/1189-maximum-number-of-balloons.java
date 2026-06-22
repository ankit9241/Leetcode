class Solution {
    public int maxNumberOfBalloons(String text) {
        int count[] = new int[26];
        
        for(char c:text.toCharArray()){
            count[c-'a']++;
        }

        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a']/2; // kyuki 2 l aata h balloon me 
        int o = count['o' - 'a']/2; // same 
        int n = count['n' - 'a'];

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}