class Solution {
    public String simplifyPath(String path) {
        Stack <String> stack = new Stack<>();
        String[] components = path.split("/");

        for(String directory : components) {
            if(directory.equals(".") || directory.isEmpty()) {
                continue;
            }
            if(directory.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(directory);
            }
        }
        StringBuilder result = new StringBuilder();
        for(String dir : stack){
            result.append("/").append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}