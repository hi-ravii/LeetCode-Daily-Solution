// You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

// You can swap the characters at any pair of indices in the given pairs any number of times.

// Return the lexicographically smallest string that s can be changed to after using the swaps.

 

// Example 1:

// Input: s = "dcab", pairs = [[0,3],[1,2]]
// Output: "bacd"
// Explaination: 
// Swap s[0] and s[3], s = "bcad"
// Swap s[1] and s[2], s = "bacd"
// Example 2:

// Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
// Output: "abcd"
// Explaination: 
// Swap s[0] and s[3], s = "bcad"
// Swap s[0] and s[2], s = "acbd"
// Swap s[1] and s[2], s = "abcd"
// Example 3:

// Input: s = "cba", pairs = [[0,1],[1,2]]
// Output: "abc"
// Explaination: 
// Swap s[0] and s[1], s = "bca"
// Swap s[1] and s[2], s = "bac"
// Swap s[0] and s[1], s = "abc"
 

// Constraints:

// 1 <= s.length <= 10^5
// 0 <= pairs.length <= 10^5
// 0 <= pairs[i][0], pairs[i][1] < s.length
// s only contains lower case English letters.
class Solution {
    int[] parent;
    int[] rank;
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n =s.length();
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i<n; i++) parent[i] = i;
        
        for(List<Integer> v : pairs){
            union(v.get(0), v.get(1));  // union of all the pairs that can be swappped
        }
        for(int i = 0; i<n; i++){
            parent[i] = find(parent[i]); // making sure that the connected components have a same parent in parent[i]
        }
        
        HashMap<Integer, ArrayList<Character>> map = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            ArrayList<Character> list = map.getOrDefault(parent[i], new ArrayList<>());
            list.add(s.charAt(i));
            map.put(parent[i], list); // adding all the character corresponding to thier parent Index
        }
        
        for(ArrayList<Character> a : map.values()){
            Collections.sort(a, (x,y) -> y-x);  // sorting all the connected components
        }
        
        char[] ch = new char[n];
        for(int i = 0; i<n; i++){
            ch[i] = map.get(parent[i]).remove(map.get(parent[i]).size() - 1); // making our ans
        }
        
        return new String(ch);
    }
    
    void union(int a, int b){
        int x = find(a), y = find(b);
        if(x == y) return;
        if(rank[x] > rank[y]){
            parent[y] = x;
        }else if(rank[y] > rank[x]){
            parent[x] = y;
        }else{
            parent[x] = y;
            rank[y]++;
        }
    }
    
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}