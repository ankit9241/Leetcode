class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n= nums.length;
        int validSubarraysCount = 0;

        for(int i=0; i<n; i++){
            int targetCount = 0;
            int totalElements  =0;

            for(int j=i; j< n; j++){
                totalElements++;
                if(nums[j] == target){
                    targetCount++;
                }

                if(targetCount > totalElements /2){
                    validSubarraysCount++;
                }
            }
        }
        return validSubarraysCount;
    }
}