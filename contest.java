int n = processes.size();
int sum =0
for(int i =0;i<n;i++){
    sum+=processes.get(i);
}
int curr =0,i=0,j=0,max= Integer.MIN_VALUE;
while(j<n){
    curr+=processes.get(j);
    if(j-i+1<m){
        j++;
    }
    else if(j-i+1==m){
        max = Math.max(max,curr);
        curr-=processes.get(i);
        i++;
        j++;
    }
}
return sum-max;