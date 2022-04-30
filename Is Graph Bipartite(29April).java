// There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
// A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

// Return true if and only if it is bipartite.

 

// Example 1:


// Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
// Output: false
// Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
// Example 2:


// Input: graph = [[1,3],[0,2],[1,3],[0,2]]
// Output: true
// Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 

// Constraints:

// graph.length == n
// 1 <= n <= 100
// 0 <= graph[u].length < n
// 0 <= graph[u][i] <= n - 1
// graph[u] does not contain u.
// All the values of graph[u] are unique.
// If graph[u] contains v, then graph[v] contains u.
class Solution {
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        //maintain a colors array with the graph length
        int[] colors = new int[length];
        //fill the array with 0 (Not colored)
        Arrays.fill(colors, 0);
        //loop through the length of the graph
        for (int i= 0;i<length;i++){
            //process only if the color is 0, skip if its anything other than 0
            if (colors[i] == 0){
                //add to the q
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                //set the color to 1 (Blue)
                colors[i] = 1;
                // loop until q is empty
                while (!q.isEmpty()){
                    int n = q.poll();
                    //for each element in the graph of i
                    for (int j: graph[n]){
                        //process only for 0 (Not colored)
                        if (colors[j] == 0){
                            //set the color to negative for the vertex j
                            colors[j] = -colors[n]; // -1 (Red) flip to opposite color
                            //add the vertex to the queue
                            q.offer(j);
                        }
                        // if the color of the vertex is a different color return false
                        else if(colors[j] != -colors[n]) return false;
                    }
                }
            }
        }
        return true;
    }
}  