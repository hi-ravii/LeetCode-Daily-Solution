// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

 

// Example 1:

// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4
 

// Constraints:

// 1 <= capacity <= 3000
// 0 <= key <= 104
// 0 <= value <= 105
// At most 2 * 105 calls will be made to get and put.

// SOLUTION 1 : USING DOUBLY LINKED LIST AND HASHMAP
//COPY ME EXPLANATION HAI
class LRUCache {
    class Node{//node will be consist of the address of nodes in doubly linked list
        int key,value;
        Node prev,next;
        Node(int _key,int _value){
            key = _key;
            value = _value;
        }
    }
    Node head =new Node(0,0);//initializing head of doubly linked list
    Node tail = new Node(0,0);//initializing tail of doubly linked list
    int capacity;
    Map<Integer, Node> map = new HashMap<>();//map will store the key value and the address of nodes (key,value) in doubly linked list
    
    public LRUCache(int _capacity) {
        head.next =tail;
        tail.prev = head;
        capacity = _capacity;
        
    }
    
    public int get(int key) {
        //agr map me key h toh uska value return kro aur uska node ko  remove kro and usko head.next me daal do
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else return -1;//agr map me woh key h hi nhi  toh -1 return kro
    }
    
    public void put(int key, int value) {
//1 case = agr map me woh key phle se h toh usko remove kro map se aur nyi key value daal do aur uss naye nodde ko head.next pe daal do
//2 case = agr map me woh key nhi h toh usko map me daal do aur usko head.next pe daal do
//3 case = agr map me woh key nhi h aur map ka size capacity k barabr phle se hi h toh tail.prev ko remove kro map as well as linked list se aur naya node daal do map me aur head.next pe
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    public void insert(Node node){
        //inserting node at head.next and adding it to map as well
        
        map.put(node.key,node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public void remove(Node node){
        //removing node from map as well as linked list
        map.remove(node.key);
        node.prev.next =node.next;
        node.next.prev = node.prev;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */