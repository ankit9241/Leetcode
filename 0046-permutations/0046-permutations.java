class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int num : nums){
            current.add(num);
        }
        backtrack(0, current, result);
        return result;
    }

    private void backtrack(int start, List<Integer> current, List<List<Integer>>result){
        if(start == current.size()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i =start; i< current.size(); i++){
            swap(current, start, i);
            backtrack(start+1, current,result);
            swap(current, start, i);
        }
    }

    private void swap (List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}