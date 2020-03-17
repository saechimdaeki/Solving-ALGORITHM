#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
int main()
{
	int N;
	cin>>N;
	v.reserve(N+1);
	vector<int> dynamic(N+1,-1);
	dynamic[0]=1;
	for(int i=1; i<=N; i++)
	cin>>v[i];
	
	for(int i=1; i<=N;i++)
		for(int j=1; j<=i; j++)
			if(dynamic[i]==-1 || dynamic[i]>dynamic[i-j]+v[j])
				dynamic[i]=dynamic[i-j]+v[j];
	

	cout<<dynamic[N]-1;
}
