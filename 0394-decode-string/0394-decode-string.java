class Solution {
    public String decodeString(String s) {
       Stack <Integer> counts= new Stack<>();
       Stack <StringBuilder> resultStack = new Stack<>();
       StringBuilder current = new StringBuilder();
       int k =0;

       for(char ch : s.toCharArray()){
        if(Character.isDigit(ch)){
            k = k *10 + (ch - '0');
        }else if (ch == '['){
            counts.push(k);
            resultStack.push(current);
            current = new StringBuilder();
            k = 0;
        }else if (ch == ']') {
            StringBuilder decoded = resultStack.pop();
            int currentK = counts.pop();
            for(int i=0; i<currentK; i++){
                decoded.append(current);
            }
            current = decoded;
        }else{
            current.append(ch);
        }
       } 
       return current.toString();
    }
}