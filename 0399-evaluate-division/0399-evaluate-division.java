import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프 구축
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        
        // 결과를 저장할 배열
        double[] results = new double[queries.size()];
        
        // 각 쿼리에 대해 BFS 수행
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            
            // 만약 시작 변수나 끝 변수가 그래프에 존재하지 않으면 -1.0
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            }
            // 동일한 변수 간의 비율은 항상 1.0
            else if (start.equals(end)) {
                results[i] = 1.0;
            }
            else {
                results[i] = bfs(graph, start, end);
            }
        }
        
        return results;
    }
    
    // 그래프를 구축하는 메서드
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String A = eq.get(0);
            String B = eq.get(1);
            double value = values[i];
            
            // A에 대한 초기화
            graph.putIfAbsent(A, new HashMap<>());
            // B에 대한 초기화
            graph.putIfAbsent(B, new HashMap<>());
            
            // A -> B = value
            graph.get(A).put(B, value);
            
            // B -> A = 1 / value
            graph.get(B).put(A, 1.0 / value);
        }
        
        return graph;
    }
    
    // BFS를 사용하여 경로를 탐색하고 값을 계산하는 메서드
    private double bfs(Map<String, Map<String, Double>> graph, String src, String target) {
        // BFS를 위한 큐 초기화 (각 요소는 [현재 노드, 누적 값] 배열)
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{src, 1.0});
        
        // 방문한 노드를 추적하기 위한 집합
        Set<String> visited = new HashSet<>();
        visited.add(src);
        
        while (!queue.isEmpty()) {
            Object[] current = queue.poll();
            String currentNode = (String) current[0];
            double currentValue = (double) current[1];
            
            // 현재 노드가 목표 노드인 경우 누적 값을 반환
            if (currentNode.equals(target)) {
                return currentValue;
            }
            
            // 현재 노드의 인접 노드 탐색
            Map<String, Double> neighbors = graph.getOrDefault(currentNode, new HashMap<>());
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String neighbor = entry.getKey();
                double value = entry.getValue();
                
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new Object[]{neighbor, currentValue * value});
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
