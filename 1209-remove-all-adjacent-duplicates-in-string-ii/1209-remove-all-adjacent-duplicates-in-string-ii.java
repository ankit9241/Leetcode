class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count++;
                if(stack.peek().count == k){
                    stack.pop();
                }
            }else{
                    stack.push(new Pair(c, 1));
            }
        }    
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair p = stack.removeLast();
            for(int i=0; i<p.count; i++){
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
    private static class Pair{
        char ch;
        int count;

        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
}
