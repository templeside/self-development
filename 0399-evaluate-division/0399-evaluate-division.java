import java.util.*;

class Solution {
    // 그래프를 표현하기 위한 인접 리스트
    private Map<String, List<Pair>> graph = new HashMap<>();

    // 엣지 정보를 저장할 Pair 클래스
    private static class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프 구축
        buildGraph(equations, values);

        double[] results = new double[queries.size()];

        // 각 쿼리에 대해 BFS를 통해 결과 계산
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                // 시작 변수나 끝 변수가 그래프에 존재하지 않는 경우
                results[i] = -1.0;
            } else if (start.equals(end)) {
                // 동일한 변수 간의 비율은 항상 1.0
                results[i] = 1.0;
            } else {
                // BFS를 사용하여 경로 탐색
                results[i] = bfs(start, end);
            }
        }

        return results;
    }

    // 그래프를 구축하는 메서드
    private void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String A = eq.get(0);
            String B = eq.get(1);
            double value = values[i];

            // A와 B가 그래프에 존재하지 않으면 추가
            graph.putIfAbsent(A, new ArrayList<>());
            graph.putIfAbsent(B, new ArrayList<>());

            // A -> B = value
            graph.get(A).add(new Pair(B, value));

            // B -> A = 1 / value
            graph.get(B).add(new Pair(A, 1.0 / value));
        }
    }

    // BFS를 사용하여 경로를 탐색하고 값을 계산하는 메서드
    private double bfs(String src, String target) {
        // BFS를 위한 큐 초기화
        Queue<Pair> queue = new LinkedList<>();
        // 시작 노드와 누적 값을 큐에 추가
        queue.offer(new Pair(src, 1.0));

        // 방문한 노드를 추적하기 위한 집합
        Set<String> visited = new HashSet<>();
        visited.add(src);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String currentNode = current.node;
            double currentProduct = current.value;

            // 현재 노드가 목표 노드인 경우 누적 값을 반환
            if (currentNode.equals(target)) {
                return currentProduct;
            }

            // 현재 노드의 모든 인접 노드를 탐색
            List<Pair> neighbors = graph.getOrDefault(currentNode, new ArrayList<>());
            for (Pair neighbor : neighbors) {
                if (!visited.contains(neighbor.node)) {
                    // 인접 노드를 방문하고 누적 값을 업데이트하여 큐에 추가
                    visited.add(neighbor.node);
                    queue.offer(new Pair(neighbor.node, currentProduct * neighbor.value));
                }
            }
        }

        // 경로가 존재하지 않는 경우 -1.0 반환
        return -1.0;
    }

    // ----------------- 테스트 -----------------
    public static void main(String[] args) {
        Solution solver = new Solution();

        // 예제 1
        List<List<String>> equations1 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );
        System.out.println(Arrays.toString(solver.calcEquation(equations1, values1, queries1)));
        // 예상 출력: [6.0, 0.5, -1.0, 1.0, -1.0]

        // 예제 2
        List<List<String>> equations2 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c"),
            Arrays.asList("bc", "cd")
        );
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("c", "b"),
            Arrays.asList("bc", "cd"),
            Arrays.asList("cd", "bc")
        );
        System.out.println(Arrays.toString(solver.calcEquation(equations2, values2, queries2)));
        // 예상 출력: [3.75, 0.4, 5.0, 0.2]

        // 예제 3
        List<List<String>> equations3 = Arrays.asList(
            Arrays.asList("a", "b")
        );
        double[] values3 = {0.5};
        List<List<String>> queries3 = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "c"),
            Arrays.asList("x", "y")
        );
        System.out.println(Arrays.toString(solver.calcEquation(equations3, values3, queries3)));
        // 예상 출력: [0.5, 2.0, -1.0, -1.0]
    }
}
