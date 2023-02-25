// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         // In case of an empty string
//         if (strs.length == 0) return "";

//         // Create an object prefix with which you compare all the other strings in the array
//         // By using indexOf(prefix) we determine if the string is the common prefix of that other string
//         String prefix = strs[0];
//         for (int i = 1; i< strs.length; i++){
//             while (strs[i].indexOf(prefix) != 0){
//                 prefix = prefix.substring(0, prefix.length()-1);
//                 if (prefix.isEmpty()) return "";
//             }
//         }       
//         return prefix;
//     }
// }


// The above is a horizontal scaling with time complexity O(S) where S is the sum of the chars in m and n, with worst case time complexity being m.n

//The next approach is Divide and Conquer. Since the LCP property of the string array is associative, we can
// recursively divide the array into two and get the same solution.


// class Solution{
//     /* Main Function
//      @Paramters : String[] strs
//      @Returns : Longest Common prefix of the given string
//     */
    
//     public String longestCommonPrefix(String[] strs){
//         // In case of null or empty string
//         if (strs == null || strs.length == 0) return "";
//             return longestCommonPrefix(strs, 0 , strs.length -1);
//     }

//     /*  Method Overloaded
//         Dividing Function- Divides the given array into two using left and right pointer
//         @Return : returns the common prefix of the subdivided array
//     */

//     private String longestCommonPrefix(String[] strs, int l, int r){
//         if (l==r){ 
//             return strs[l];
//         }
//         else{
//             int mid = l+(r-l)/2;
//             String lcpLeft = longestCommonPrefix(strs, 1, mid);
//             String lcpRight = longestCommonPrefix(strs, mid+1, r);
//             return commonPrefix(lcpLeft, lcpRight);
//         }
//     }
//     /* 
//         Comparison Function
//         @Input : Two String Inputs, left and right
//         @Logic :   
//         @Returns : Comparsion of the two strings

//     */

//     String commonPrefix(String left, String right){
//         int min = Math.min(left.length(), right.length());
//         for (int i = 0; i< min; i++){
//             if (left.charAt(i) != right.charAt(i))
//                 return left.substring(0,i);
//         }
//         return left.substring(0, min);
//     }
// }
class longestCommonPrefixSolution{
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    
    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
        }
    }