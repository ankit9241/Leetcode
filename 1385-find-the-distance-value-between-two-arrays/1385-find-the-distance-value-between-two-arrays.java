class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count =0;
        for(int i=0; i<arr1.length; i++){
            int minDiff = Integer.MAX_VALUE;
            for(int j=0; j< arr2.length; j++){
                int diff = Math.abs(arr1[i] - arr2[j]);
                minDiff = Math.min(minDiff, diff);
            }
            if(minDiff > d){
                count++;
            }
        }
        return count;
    }
}