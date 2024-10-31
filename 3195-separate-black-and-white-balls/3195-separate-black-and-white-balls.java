class Solution {
    public long minimumSteps(String s) {
        long result = 0;
        long countZero = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                countZero++;
            } else {
                result += countZero;
            }
        }

        return result;
    }
}