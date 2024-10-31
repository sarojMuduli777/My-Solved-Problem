class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char ch : s.toCharArray()) {
            while (i < t.length()) {
                if (ch == t.charAt(i)) {                    
                    break;
                }
                i++;
            }
            if (i == t.length()) {
                return false;
            }
            i++;
        }

        return true;
    }
}