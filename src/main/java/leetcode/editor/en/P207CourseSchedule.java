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
        // use Topological Sort
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (numCourses <= 1) return true;
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            int[] inDegree = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                adjList.get(prerequisite[1]).add(prerequisite[0]);
                inDegree[prerequisite[0]]++;
            }

            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) q.add(i);
            }
            List<Integer> topo = new ArrayList<Integer>();
            while (!q.isEmpty()) {
                int node = q.poll();
                topo.add(node);
                for (int neighbor : adjList.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) q.add(neighbor);
                }
            }
            return topo.size() == numCourses;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}