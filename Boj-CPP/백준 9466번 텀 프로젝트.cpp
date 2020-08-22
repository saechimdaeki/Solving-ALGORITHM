#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>
#define endl '\n'
using namespace std;
vector<int> v;
bool visited[100001];
bool checked[100001];
int n,t,cnt;
void dfs(int n1)
{
	visited[n1]=true;
	int next_(v[n1]);
	if(visited[next_]==false)
		dfs(next_);
	else 
	{
		if(checked[next_]==false)
		{
		for (int i=next_;i!=n1;i=v[i])
			 cnt++;
			cnt++;	
		}
	}
	checked[n1]=true;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	while(t--)
	{
		v.clear();
		v.resize(100001);
		memset(visited,false,sizeof(visited));
		memset(checked,false,sizeof(checked)); 
		cin>>n;
		for(int i=1; i<=n; i++)
			cin>>v[i];
		cnt=0;
		for(int i=1; i<=n; i++)
		{
			if(visited[i]==false)
			dfs(i);
		}
		cout<<n-cnt<<endl;
	}	
}
