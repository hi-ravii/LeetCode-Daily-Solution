// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

// Implement the NestedIterator class:

// NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
// int next() Returns the next integer in the nested list.
// boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
// Your code will be tested with the following pseudocode:

// initialize iterator with nestedList
// res = []
// while iterator.hasNext()
//     append iterator.next() to the end of res
// return res
// If res matches the expected flattened list, then your code will be judged as correct.

 

// Example 1:

// Input: nestedList = [[1,1],2,[1,1]]
// Output: [1,1,2,1,1]
// Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
// Example 2:

// Input: nestedList = [1,[4,[6]]]
// Output: [1,4,6]
// Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 

// Constraints:

// 1 <= nestedList.length <= 500
// The values of the integers in the nested list is in the range [-106, 106].
USING QUEUE

public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> q = new LinkedList();

    public NestedIterator(List<NestedInteger> nestedList) {
        fillup(nestedList);
    }

    @Override
    public Integer next() {
        if(!q.isEmpty())
            return (Integer)q.poll();
            
        return null;
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
    
    private void fillup(List<NestedInteger> nestedlist)
    {
        if(nestedlist == null)
            return;
        
        for(NestedInteger member:nestedlist)
        {
            if(member.isInteger())
            {
                q.offer(member.getInteger());
            }
            else
            {
                fillup(member.getList());
            }
        }
    }
}
USING STACK

public class NestedIterator implements Iterator<Integer> {
    Stack<ListIterator<NestedInteger>> stack;
    NestedInteger cache;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        return cache.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (true) {
            if (stack.isEmpty()) break;
            if (!stack.peek().hasNext()) {
                stack.pop();
                continue;
            }
            
            cache = stack.peek().next();
            if (!cache.isInteger()) {
                stack.push(cache.getList().listIterator());
                continue;
            }
            
            return true;
        }
        return false;
    }
}
USING ARRAYLIST

 public class NestedIterator implements Iterator<Integer> {

         List<Integer> res = new ArrayList<>();
         int index = 0;

     public NestedIterator(List<NestedInteger> nestedList) {
              res = helper(nestedList);
       }

     private  List<Integer> helper(List<NestedInteger> list){
                List<Integer> cur = new ArrayList<>();
                for(NestedInteger x: list){
                       if(x.isInteger()) cur.add(x.getInteger());
                       else{
                              List<Integer> remain = helper(x.getList());
                              cur.addAll(remain);
                       }
               }
             return cur;
      }
      @Override
      public Integer next() {
              if(this.hasNext())
                     return res.get(index++);
             else return -1;
      }

      @Override
     public boolean hasNext() {
               return index < res.size();
     }
}