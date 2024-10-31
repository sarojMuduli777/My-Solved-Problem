class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int requiredValue = target - nums[i];
            
            if (map.containsKey(requiredValue)) {
                return new int[]{i, map.get(requiredValue)};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}