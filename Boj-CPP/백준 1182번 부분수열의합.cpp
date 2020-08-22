#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
int n,s;
int answer;
void dfs(int i, int len, int sum)
{
	if(i==n)
	{
		if(len!=0 && sum==s )
			answer++;
			return;	
	}
	dfs(i+1,len+1,sum+v[i]);
	dfs(i+1,len,sum);
	
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>s;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i];
	}
	dfs(0,0,0);
	cout<<answer;	
}

