class Solution(object):
    def containsDuplicate(self, nums):
        return True if len(set(nums)) < len(nums) else False