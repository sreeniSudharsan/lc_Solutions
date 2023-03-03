// Brute Force Solution, we use sliding window algorithm

// class Solution {
//     public int strStr(String haystack, String needle) {
//         int n = needle.length()
//         int m = haystack.lenght()

//         for(int windowSt = 0; windowSt<=m-n; windowSt++){
//             for (int i=0; i<n; i++){
//                 if(needle.chatAt(i) != haystack.charAt(widowSt + i){
//                     break;
//                 }
//                 if( i== n-1){
//                     return windowSt
//                 })
//             }
//         }
//         return -1;
        
//     }
// Time Complexity: O(mn)
// Space Complexity: O(1)
// }


// //Robin Karp Double Hash Algorithm
// class Solution {

//     // CONSTANTS
//     final int RADIX_1 = 26;
//     final int MOD_1 = 1000000033;
//     final int RADIX_2 = 27;
//     final int MOD_2 = 2147483647;

//     // Return Array of Hash Values
//     public long[] hashPair(String string, int m) {
//         long hash1 = 0, hash2 = 0;
//         long factor1 = 1, factor2 = 1;

//         for (int i = m - 1; i >= 0; i--) {
//             hash1 += ((int) (string.charAt(i) - 'a') * (factor1)) % MOD_1;
//             factor1 = (factor1 * RADIX_1) % MOD_1;
//             hash2 += ((int) (string.charAt(i) - 'a') * (factor2)) % MOD_2;
//             factor2 = (factor2 * RADIX_2) % MOD_2;
//         }

//         return new long[] { hash1 % MOD_1, hash2 % MOD_2 };
//     }

//     public int strStr(String haystack, String needle) {
//         int m = needle.length();
//         int n = haystack.length();
//         if (n < m)
//             return -1;

//         // COMPUTING CONSTANTS
//         long MAX_WEIGHT_1 = 1;
//         long MAX_WEIGHT_2 = 1;
//         for (int i = 0; i < m; i++) {
//             MAX_WEIGHT_1 = (MAX_WEIGHT_1 * RADIX_1) % MOD_1;
//             MAX_WEIGHT_2 = (MAX_WEIGHT_2 * RADIX_2) % MOD_2;
//         }

//         // Compute hash pair of needle
//         long[] hashNeedle = hashPair(needle, m);
//         long[] hashHay = { 0, 0 };

//         // Check for each m-substring of haystack, starting at index windowStart
//         for (int windowStart = 0; windowStart <= n - m; windowStart++) {
//             if (windowStart == 0) {
//                 // Compute hashPair of First Substring
//                 hashHay = hashPair(haystack, m);
//             } else {
//                 // Update Hash Pair using Previous Hash Value in O(1)
//                 hashHay[0] = ((hashHay[0] * RADIX_1) % MOD_1
//                         - ((int) (haystack.charAt(windowStart - 1) - 'a') * MAX_WEIGHT_1) % MOD_1
//                         + (int) (haystack.charAt(windowStart + m - 1) - 'a') + MOD_1) % MOD_1;
//                 hashHay[1] = ((hashHay[1] * RADIX_2) % MOD_2
//                         - ((int) (haystack.charAt(windowStart - 1) - 'a') * MAX_WEIGHT_2) % MOD_2
//                         + (int) (haystack.charAt(windowStart + m - 1) - 'a') + MOD_2) % MOD_2;
//             }

//             // If the hash matches, return immediately. Probability of Spurious Hit tends to zero.
//             if (hashNeedle[0] == hashHay[0] && hashNeedle[1] == hashHay[1]) {
//                 return windowStart;
//             }
//         }

//         return -1;
//     }
// }


//The below solution is using the indexOf inbuilt function in java, which is once again using the implementation of a string finding algo.
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}