#include<iostream>
#include<vector>
#include<algorithm>
#include<functional>
using namespace std;
vector<int> v;
int n;
int dynamic[1001];
int count123(1); 
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	dynamic[0]=1;
	for(int i=1; i<n; i++)
	{
		dynamic[i]=1;
		for(int j=0; j<i; j++)
			if(v[i]>v[j]&&dynamic[i]<dynamic[j]+1)
				dynamic[i]=dynamic[j]+1;
		count123=max(count123,dynamic[i]);		
		
	}
	cout<<count123<<"\n";
	
}
