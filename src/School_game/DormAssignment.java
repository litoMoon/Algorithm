package School_game;

import java.util.*;

//public class Demo7 {
//    public static void main1(String[] args) {
//        Scanner scan=new Scanner(System.in);
//        int m=scan.nextInt();
//        int n=scan.nextInt();
//        int []hash=new int[1001];
//        for (int i = 0; i < n; i++) {
//            int a=scan.nextInt();
//            int b=scan.nextInt();
//            hash[a]++; hash[b]++;
//        }
//        int count=0;
//        for (int i = 0; i < hash.length; i++) {
//            if(hash[i]>=2) count++;
//        }
//        if(count>=3) System.out.println("No");
//        else System.out.println("Yes");
//    }
//
//        public static void main2(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//
//            // 读取学生数量N和矛盾数量M
//            int N = scanner.nextInt();
//            int M = scanner.nextInt();
//
//            // 创建一个Map来存储矛盾关系
//            Map<Integer, Integer> conflicts = new HashMap<>();
//            for (int i = 0; i < M; i++) {
//                int u = scanner.nextInt();
//                int v = scanner.nextInt();
//                conflicts.put(u, v);
//                conflicts.put(v, u); // 因为矛盾是双向的，所以存储两次
//            }
//
//            // 使用回溯法尝试分配学生
//            boolean[] assigned = new boolean[N + 1]; // 记录学生是否已被分配
//            boolean result = canAllocate(1, N, conflicts, assigned);
//
//            // 输出结果
//            if (result) {
//                System.out.println("Yes");
//            } else {
//                System.out.println("No");
//            }
//
//            scanner.close();
//        }
//
//        // 回溯法尝试分配学生
//        private static boolean canAllocate(int student, int N, Map<Integer, Integer> conflicts, boolean[] assigned) {
//            // 所有学生都分配完毕，没有冲突发生
//            if (student > N) {
//                return true;
//            }
//
//            // 尝试将学生分配到第一栋楼
//            boolean[] tempAssigned = assigned.clone();
//            tempAssigned[student] = true;
//            if (!hasConflict(student, tempAssigned, conflicts)) {
//                if (canAllocate(student + 1, N, conflicts, tempAssigned)) {
//                    return true;
//                }
//            }
//
//            // 尝试将学生分配到第二栋楼（即不标记为已分配）
//            if (!assigned[student] && !hasConflict(student, assigned, conflicts)) {
//                if (canAllocate(student + 1, N, conflicts, assigned)) {
//                    return true;
//                }
//            }
//
//            // 无法分配
//            return false;
//        }
//
//        // 检查分配是否存在冲突
//        private static boolean hasConflict(int student, boolean[] assigned, Map<Integer, Integer> conflicts) {
//            for (int i = 1; i <= assigned.length - 1; i++) {
//                if (assigned[i] && conflicts.containsKey(student) && conflicts.get(student) == i) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public static void main3(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//
//            // 读取学生和矛盾的数量
//            int N = scanner.nextInt();
//            int M = scanner.nextInt();
//
//            // 初始化矛盾数组
//            int[] conflicts = new int[N + 1]; // 数组下标从1开始使用，方便对应学生编号
//
//            // 读取矛盾信息
//            for (int i = 0; i < M; i++) {
//                int u = scanner.nextInt(); // u号学生
//                int v = scanner.nextInt(); // v号学生
//                conflicts[u]++; // u号学生的矛盾数量加1
//                conflicts[v]++; // v号学生的矛盾数量加1
//            }
//
//            // 检查是否可以分配
//            boolean canAllocate = true;
//            for (int i = 1; i <= N; i++) {
//                if (conflicts[i] > 1) {
//                    canAllocate = false;
//                    break;
//                }
//            }
//
//            // 输出结果
//            if (canAllocate) {
//                System.out.println("Yes");
//            } else {
//                System.out.println("No");
//            }
//
//            scanner.close();
//        }

    public class DormAssignment {
        private int[] color;
        private boolean[] visited;
        private boolean isBipartite = true;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            DormAssignment solution = new DormAssignment(n);
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                solution.addEdge(u, v);
            }

            if (!solution.isBipartite()) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }

        public DormAssignment(int n) {
            this.color = new int[n];
            this.visited = new boolean[n];
        }

        private void addEdge(int u, int v) {
            // 这里假设图已经构建好，只需要添加边即可
        }

        private boolean dfs(int node, int parentColor) {
            visited[node] = true;
            color[node] = 1 - parentColor;

            for (int neighbor : getNeighbors(node)) { // 假设这里有一个方法返回node的所有邻居
                if (!visited[neighbor]) {
                    if (!dfs(neighbor, color[node])) {
                        return false;
                    }
                } else if (color[neighbor] == color[node]) {
                    isBipartite = false;
                    return false;
                }
            }

            return true;
        }

        private List<Integer> getNeighbors(int node) {
            // 返回node的所有邻居列表
            return null;
        }

        public boolean isBipartite() {
            Arrays.fill(visited, false);

            for (int i = 0; i < color.length && isBipartite; i++) {
                if (!visited[i]) {
                    dfs(i, 0); // 从第i个节点开始进行DFS
                }
            }

            return isBipartite;
        }
    }
//    }
