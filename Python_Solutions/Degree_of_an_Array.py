#Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

#Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 

class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        num_map = {}
        count = 1
        sub_len = 0
        
        for ind in range(len(nums)) :
            if num_map.get(nums[ind]) :
                num_map[nums[ind]][1] = ind
                num_map[nums[ind]][2] = num_map[nums[ind]][2] + 1
            else :
                num_map[nums[ind]] = [ind, ind, 1]
            if  num_map[nums[ind]][2] > count \
                    or (num_map[nums[ind]][2] >= count \
                    and num_map[nums[ind]][1] - num_map[nums[ind]][0] <= sub_len) :
                count = num_map[nums[ind]][2] 
                sub_len = num_map[nums[ind]][1] - num_map[nums[ind]][0] 
     
        return sub_len + 1