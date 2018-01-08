Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        // so we can skip processing the same number
        Arrays.sort(nums);

        // intermediate result
        List<Integer> newList = new ArrayList<Integer>();

        boolean[] picked = new boolean[nums.length];
        helper(nums, newList, result, picked);

        return result;
    }

    private void helper(int[] nums, List<Integer> newList, List<List<Integer>> result, boolean[] picked) {
        if (newList.size() == nums.length) {
            // finished filling in one list
            result.add(new ArrayList<Integer>(newList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (picked[i]) {
                continue;
            }

            picked[i] = true;
            newList.add(nums[i]);
            helper(nums, newList, result, picked);
            picked[i] = false;
            // reuse the list
            newList.remove(newList.size() - 1);

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
