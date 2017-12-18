/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:
[
  [7],
  [2, 2, 3]
]
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // more efficient b/c once current number is > remaining, all numbers after it don't qualify
        // so don't need to proceed
        Arrays.sort(candidates);
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        helper(candidates, result, new ArrayList<Integer>(), target, 0);
        return result;
    }

    private void helper(int[] candidates, List<List<Integer>> result, List<Integer> temp, int remaining, int startingIndex) {
        if (remaining == 0) {
            result.add(new ArrayList<Integer>(temp));
        }

        // start at the given index so will not have duplicate outputs
        for (int i = startingIndex; i < candidates.length; i++) {
            // use backtracking technique
            if (candidates[i] <= remaining) {
                temp.add(candidates[i]);
                helper(candidates, result, temp, remaining - candidates[i], i);
                temp.remove(temp.size() - 1);
            }

        }

    }
}
