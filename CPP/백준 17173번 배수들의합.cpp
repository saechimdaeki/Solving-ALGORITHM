#include<iostream>
#include<vector>
#include<functional>

using namespace std;
int n,m,t;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin>>n>>m;
	vector<int> arr(n+1,0);
	for(int i=0; i<m; i++)
	{
		cin>>t;
		for(int i=t; i<=n; i+=t)
		arr[i]=1;
	}
	int ans(0);
	for(int i=1; i<=n; i++)
	if(arr[i])
	ans+=i;
	cout<<ans;
}
