// Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

// Implement the TimeMap class:

// TimeMap() Initializes the object of the data structure.
// void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
// String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 

// Example 1:

// Input
// ["TimeMap", "set", "get", "get", "set", "get", "get"]
// [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
// Output
// [null, null, "bar", "bar", null, "bar2", "bar2"]

// Explanation
// TimeMap timeMap = new TimeMap();
// timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
// timeMap.get("foo", 1);         // return "bar"
// timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
// timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
// timeMap.get("foo", 4);         // return "bar2"
// timeMap.get("foo", 5);         // return "bar2"
 

// Constraints:

// 1 <= key.length, value.length <= 100
// key and value consist of lowercase English letters and digits.
// 1 <= timestamp <= 107
// All the timestamps timestamp of set are strictly increasing.
// At most 2 * 105 calls will be made to set and get.
// Accepted
// 201,477
// Submissions
// 384,183
class TimeMap {
    class Data{//creating a pair of value and time to store it in hashmap as value as list of these pair
        int timestamp;
        String value;
        public Data(String value,int timestamp){
            this.timestamp=timestamp;
            this.value = value;
        }
    }
    HashMap<String,List<Data>>map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {//function for input
        if(!map.containsKey(key))map.put(key,new ArrayList<>());//if map doest have that key then add new key and list of datas as pair
        map.get(key).add(new Data(value,timestamp));//if same key is present then just add new data in the list of values
    }
    
    public String get(String key, int timestamp) {//function for output
        if(!map.containsKey(key))return "";//if key is not present then return an empty string 
        List<Data> data = map.get(key);//if key is present then store its list in data
        return findclosest(data,timestamp);//function to find the closest time
    }
    public String findclosest(List<Data>data,int timestamp){//binary search to find the closest posible
        int l=0,r=data.size()-1;
        while(l<r){
            int mid = (l+r+1)/2;//to overcome the infinite loop that will occur in normal mid condition
            if(data.get(mid).timestamp<=timestamp)l=mid;
            else r=mid-1;
        }
        Data closest = data.get(l);//left will be the closest one
        if(closest.timestamp>timestamp)return "";//if the closest one is not smaller than timestamp required then return empty string else return the closest value
        else return closest.value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */