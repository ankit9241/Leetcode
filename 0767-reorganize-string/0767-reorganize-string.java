class Solution {
    public String reorganizeString(String s) {
         int [] counts = new int [26];
         for(char c :s.toCharArray()){
            counts[c-'a']++;
         }
         int maxCount = 0;
         int maxChar = 0;
         for(int i=0; i<26; i++){
            if(counts[i] > maxCount) {
                maxCount = counts[i];
                maxChar = i;
            }
         }
         int n = s.length();
         if(maxCount > (n+1) /2){
            return "";
         }

         char[] result = new char[n];
         int index = 0;

         while(counts[maxChar] > 0){
            result[index] = (char) (maxChar + 'a');
            index += 2;
            counts[maxChar]--;
        }

        for(int i =0; i< 26; i++) {
            while(counts[i] > 0){
                if(index >=n){
                    index =1;
                }
                result[index] = (char) (i +'a');
                index +=2;
                counts[i]--;
            }
        }
        return new String(result);
    }
}