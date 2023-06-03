
### Question


<i> A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news. </i>

https://leetcode.com/problems/time-needed-to-inform-all-employees/


<br>

The idea here is that it is an heirarchial structure where the tree can be traversed top to bottom. The goal needed to acheive is to find 
the time required for all employees to know which can be found as the max time. We just need to do a DFS while we add each employee inform time
to the exisiting time. 


```
class Solution {
    int maxTime = Integer.MIN_VALUE;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(n);

        for(int i = 0; i< n; ++i){
            adjList.add(new ArrayList<Integer>());
        }

        // Making an adjacent list, each index stores the Ids of subordinate employees
        for(int i = 0; i < n; ++i){
            if(manager[i] != -1){
                adjList.get(manager[i]).add(i);
            }
        }

        dfs(adjList, informTime, headID, 0);
        return maxTime;

    }

    void dfs(ArrayList<ArrayList<Integer>> adjList, int[] informTime, int curr, int time){
        maxTime = Math.max(time, maxTime);

        for(int adjacent : adjList.get(curr)){
            dfs(adjList, informTime, adjacent, time + informTime[curr]);
        }
    }
}

```
