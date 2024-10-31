class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Create a prefix Array.
        int[] prefixArr = new int[1001];

        for (int[] trip : trips) {
            // Passenger entered.
            prefixArr[trip[1]] += trip[0];

            // Passenger exit.
            prefixArr[trip[2]] -= trip[0];
        }

        // Build the prefix Array.
        for (int i = 1; i < prefixArr.length; i++) {
            prefixArr[i] += prefixArr[i-1];            
        }

        // Validate all entries and exits.
        for (int passenger : prefixArr) {
            // if any moment it exceeds then return false directly.
            if (passenger > capacity) {
                return false;
            }            
        }

        // all right 
        return true;        
    }
}