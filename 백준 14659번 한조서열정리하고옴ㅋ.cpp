#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int n;
vector <int> v(30000);
int ans,count123;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	
	for(int i=0; i<n; i++)
	{
		int subvector=v[i];
		count123=0;///반복초기화
		for(int j=i+1; j<n; j++)
		{
			if(v[j]>subvector)
			goto z;
			else
			count123++;
		 } 
		 z:
		 ans=max(ans,count123);
	}
	cout<<ans;
	
}
