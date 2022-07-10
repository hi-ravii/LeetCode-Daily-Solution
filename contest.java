class Solution {
public:
    int latestTimeCatchTheBus(vector<int>& buses, vector<int>& passengers, int capacity) {
          sort(buses.begin(), buses.end());
           sort(passengers.begin(), passengers.end());
          set<int> v;
           int j=0, cnt=0, last=0;
                        for (int i = 0; i < buses.size(); i++) {
                            cnt=0;

while(cnt<capacity && j<passengers.size()&& passengers[j] <= buses[i]) {
    last= passengers[j];
    v.insert(passengers[j++]);
    cnt++;
}
if(i == buses.size() - 1 && cnt< capacity && last< buses [i])
    return buses.back();
                        }
if(v.size()==0) return buses.back();

auto iter= v.rbegin();

int mx=*iter;

while(v.find(mx)!=v.end()) mx--;

return mx;
    
    }
};