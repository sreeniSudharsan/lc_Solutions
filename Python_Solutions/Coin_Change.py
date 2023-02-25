#Problem Statement:
#You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

# Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

# You may assume that you have an infinite number of each kind of coin.

 

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:            
        def coinChangeInner(rem, cache):
            if rem < 0:
                return math.inf
            if rem == 0:                    
                return 0       
            if rem in cache:
                return cache[rem]
            
            cache[rem] = min(coinChangeInner(rem-x, cache) + 1 for x in coins)                         
            return cache[rem]      
        
        ans = coinChangeInner(amount, {})
        return -1 if ans == math.inf else ans
    
    # The given problem is a simple Optimal Binary Search Tree problem which has been approached with a memoization approach
    
#    class Solution:
 #   def coinChange(self, coins: List[int], amount: int) -> int:        
  #      dp=[math.inf] * (amount+1)
   #     dp[0]=0
        
    #    for coin in coins:
     #       for i in range(coin, amount+1):
      #          if i-coin>=0:
       #             dp[i]=min(dp[i], dp[i-coin]+1)
        
       # return -1 if dp[-1]==math.inf else dp[-1]