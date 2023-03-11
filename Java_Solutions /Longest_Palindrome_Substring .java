public class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String res = "";
        char[] srr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {

            // odd case
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && srr[l] == srr[r]) { // Try extend
                if (r - l + 1 > maxLength) {
                    maxLength = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            // even case
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && srr[l] == srr[r]) { // Try extend
                if (r - l + 1 > maxLength) {
                    maxLength = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}