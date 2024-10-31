class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // Get the length of the heights array
        final int n = heights.length;
        // Initialize an array to store the result for each person
        int[] ans = new int[n];
        // Create a stack to keep track of the indices of people in the queue
        Deque<Integer> stack = new ArrayDeque<>();

        // Iterate over each person in the queue
        for (int i = 0; i < n; ++i) {
            // While there are people in the stack and the current person's height is greater than or equal
            // to the height of the person at the index stored at the top of the stack
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                // Increment the count of visible people for the person at the index popped from the stack
                ++ans[stack.pop()];
            }

            // If the stack is not empty, it means there is a person in front of the current person
            // who is taller than the current person
            if (!stack.isEmpty()) {
                // Increment the count of visible people for the person at the top of the stack
                ++ans[stack.peek()];
            }
            
            // Push the current person's index onto the stack
            stack.push(i);
        }

        // Return the final array containing the count of visible people for each person
        return ans;
    }
}