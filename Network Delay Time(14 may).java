// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

// We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

// Example 1:


// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
// Example 2:

// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
// Example 3:

// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
 

// Constraints:

// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
class Solution {
    public int networkDelayTime(int[][] times, int n, int K) {
        int[][] graph = new int[n][n];
        for(int i = 0; i < n ; i++) Arrays.fill(graph[i], Integer.MAX_VALUE);
        for( int[] rows : times) graph[rows[0] - 1][rows[1] - 1] =  rows[2];        
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K - 1] = 0;
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n ; i++){
            int v = minIndex(distance, visited);
            if(v == -1)continue;
            visited[v] = true;
            for(int j = 0; j < n; j++){
                if(graph[v][j] != Integer.MAX_VALUE){
                    int newDist = graph[v][j] + distance[v];
                    if(newDist < distance[j]) distance[j] = newDist;
                }
            }
        }
        int result = 0;
        for(int dist : distance){
            if(dist == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dist);
        }
        return result;
    }
	
    private int minIndex(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && distance[i] < min){
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}