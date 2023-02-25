#ou are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

#Merge nums1 and nums2 into a single array sorted in non-decreasing order.
#The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

class Solution:
    
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        
        # Do not return anything, modify nums1 in-place instead.
        
        def mm(n1,n2,i,j,k):
            if k<0:
                if j>=0:
                    n1[i]=n1[j]
                    i-=1
                    j-=1
                else:
                    return
            elif j<0:
                if k>=0:
                    n1[i]=n2[k]
                    i-=1
                    k-=1
                else:
                    return                
            elif n1[j]>=n2[k]:
                n1[i]=n1[j]
                i-=1
                j-=1
            else:
                n1[i]=n2[k]
                i-=1
                k-=1
            
            mm(n1,n2,i,j,k)
            
        mm(nums1,nums2,m+n-1,m-1,n-1)