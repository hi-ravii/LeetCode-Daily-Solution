// You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

// You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

// Return the answers to all queries. If a single answer cannot be determined, return -1.0.

// Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

// Example 1:

// Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
// Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
// Explanation: 
// Given: a / b = 2.0, b / c = 3.0
// queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
// return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
// Example 2:

// Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
// Output: [3.75000,0.40000,5.00000,0.20000]
// Example 3:

// Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
// Output: [0.50000,2.00000,-1.00000,-1.00000]
 

// Constraints:

// 1 <= equations.length <= 20
// equations[i].length == 2
// 1 <= Ai.length, Bi.length <= 5
// values.length == equations.length
// 0.0 < values[i] <= 20.0
// 1 <= queries.length <= 20
// queries[i].length == 2
// 1 <= Cj.length, Dj.length <= 5
// Ai, Bi, Cj, Dj consist of lower case English letters and digits.
class Edge {
    
    String v;
    double value;
    
    public Edge (String v, double value) {
        
        this.v = v;
        this.value = value;
    }
}

class Solution {
    
    public void addEdge (Map<String, List<Edge>> map, String u, String v, double value) {
        
        if (!map.containsKey (u)) {
            map.put (u, new ArrayList<> ());
        }
        
        map.get (u).add (new Edge (v, value));
    }
    
    public double dfs (Map<String, List<Edge>> map, Set<String> set, String u, String v) {
        
        if (!map.containsKey (u) || !map.containsKey (v)) {
            return -1;
        }
        else if (u.equals (v)) {
            return 1;
        }
        
        for (Edge edge : map.get (u)) {
            if (set.contains (edge.v)) {
                continue;
            }
            else if (edge.v.equals (v)) {
                return edge.value;
            }
            
            set.add (u);
            double val = dfs (map, set, edge.v, v);
            if (val != -1) {
                return val * edge.value;
            }
        }
        
        return -1;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        double[] answer = new double[queries.size ()];
        Map<String, List<Edge>> map = new HashMap<> ();
        
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get (i);
            addEdge (map, equation.get (0), equation.get (1), values[i]);
            addEdge (map, equation.get (1), equation.get (0), 1 / values[i]);
        }
        
        for (int i = 0; i < answer.length; i++) {
            List<String> query = queries.get (i);
            answer[i] = dfs (map, new HashSet<> (), query.get (0), query.get (1));
        }
        
        return answer;
    }
}