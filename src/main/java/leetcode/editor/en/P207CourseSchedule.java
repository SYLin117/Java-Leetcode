package leetcode.editor.en;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P207CourseSchedule {
    public static void main(String[] args) {
        // Solution solution = new P207 Solution();
        Solution sol = new P207CourseSchedule().new Solution();
        int[][] prerequisites = new int[1][];
        prerequisites[0] = new int[]{1, 0};
        System.out.println(sol.canFinish(2, prerequisites));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses == 1) return true;
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            // Build adjacency list and calculate in-degrees
            int[] inDegree = new int[numCourses];
            for (int[] pre : prerequisites) {
                // Add edge from prerequisite to course
                adjList.get(pre[1]).add(pre[0]); // [1, 0] mean 0 -> 1
                // Increment in-degree of course
                inDegree[pre[0]]++; // we need indegree to do topological sort
            }

            // Perform topological sorting using BFS
            Queue<Integer> q = new LinkedList<>();
            // Enqueue courses with in-degree 0 (no prerequisites)
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }

            // Store topological order
            ArrayList<Integer> topoSeries = new ArrayList<>();
            while (!q.isEmpty()) {
                int node = q.poll();
                topoSeries.add(node);
                // Update in-degrees of dependent courses
                for (int neighbor : adjList.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        // Enqueue course if it has no more prerequisites
                        q.add(neighbor);
                    }
                }
            }

            // If topological order contains all courses, then it's possible to complete them
            return topoSeries.size() == numCourses;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}