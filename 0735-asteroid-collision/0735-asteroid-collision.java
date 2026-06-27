class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int ast: asteroids){
            while(!stack.isEmpty() && ast < 0 && stack.peek() > 0){
                int diff = ast + stack.peek();
                if(diff < 0){
                    stack.pop();
                }else if(diff > 0){
                    ast=0;
                }else{
                    stack.pop();
                    ast=0;
                }
            }
            if(ast!=0){
                stack.push(ast);
            }
        }
        int result[] = new int[stack.size()];
        for(int i= result.length -1 ;i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}