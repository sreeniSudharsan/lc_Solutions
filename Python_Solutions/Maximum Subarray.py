#Maximum Subarray
# Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
#A subarray is a contiguous part of an array.

class Solution(object):
    def maxSubArray(self, nums):
        n = len(nums)
        if n == 1:
            return nums[0] #To check whether if the given array contains only one element inside
        max_sol = cumsum = nums[0] 
        for num in nums[1:]:
            if cumsum < 0 and num > cumsum:
                cumsum = num   #To remove all the negative integers which would reduce the sum in the given subarray. 
            else:
                cumsum += num #Adding on the cummalative sum to the current number
            max_sol = max(max_sol, cumsum) #Comparing the first value with the cummulative sum
        return max_sol