class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();

        // Read the current number from input Stream by default input number
        // strat from 1.
        int inputNum = 1;

        // Loop over the array.
        for (int i = 0; i < target.length; i++) {
            // if curretn array element is equla ot input number then derectly add
            // "Push".
            if (target[i] == inputNum) {
                result.add("Push");
            } else {
                // if current input number is not equla to target[i] then add 
                // "Push" and "Pop".
                while (target[i] != inputNum) {
                    result.add("Push");
                    result.add("Pop");
                    inputNum++;
                }
                // After that add "Push" (add target element).
                result.add("Push");
            }
            // Increment or read new number form input Stream.
            inputNum++;
        }

        // Return ultimate reuslt.
        return result;
    }
}