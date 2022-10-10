#include <bits/stdc++.h>
using namespace std; 
int minimumGroups(int awards[],int n,int k)
{    
sort(awards,awards+n);    
int i=1;     
int group_count=1;       
int min_element=awards[0];    
while(i<n)
{        
if(awards[i]-min_element<=k)
{             
i++;         
}     
else
{             
group_count++;                         
min_element=awards[i];                       
i++;         
}     
}    
return group_count; 
}  
int main() 
{         
int size;    
cin>>size;    
int awards[size];              
for(int i=0;i<size;i++)
{        
 cin>>awards[i];    
 }    
int k;       
cin>>k;
cout<<minimumGroups(awards,size,k);     
return 0; 
}