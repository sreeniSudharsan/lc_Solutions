#Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

#You may assume that each input would have exactly one solution, and you may not use the same element twice.

#You can return the answer in any order

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res=[]
        for i, j in enumerate(nums):
            temp=(target - j)            
            if temp in nums:
                if i != nums.index(temp):
                    res.append(i)
                    res.append(nums.index(temp))
                    return res
        return res
    
    
# How to do this with a dictionary


     
                    