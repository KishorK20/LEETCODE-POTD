//You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given a 2D integer array relations where relations[j] = [prevCoursej, nextCoursej] denotes that course prevCoursej has to be completed before course nextCoursej (prerequisite relationship). Furthermore, you are given a 0-indexed integer array time where time[i] denotes how many months it takes to complete the (i+1)th course.

//You must find the minimum number of months needed to complete all the courses following these rules:

//You may start taking a course at any time if the prerequisites are met.
//Any number of courses can be taken at the same time.
//Return the minimum number of months needed to complete all the courses.

//Note: The test cases are generated such that it is possible to complete every course (i.e., the graph is a directed acyclic graph).

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for (int[] edge: relations) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            indegree[edge[1] - 1]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                
            }
            maxTime[i] = time[i];
        }
        int node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            for (int neighbor: graph.get(node)) {
                maxTime[neighbor] = Math.max(maxTime[neighbor], maxTime[node] + time[neighbor]);
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        int ans = 0;
        for ( node = 0; node < n; node++) {
            ans = Math.max(ans, maxTime[node]);
        }

        return ans;
        
    }
}
