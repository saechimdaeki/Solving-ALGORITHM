#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#include<cstring>
using namespace std;
int n,m,start,endd,answer;

vector<pair<int ,int> > v[100001];
bool visited[100001];
int leftt,rightt;
bool possible(int n1)
{
	memset(visited,false,sizeof(visited));
	queue<int> q;
	visited[start]=true;
	q.push(start);
	while(!q.empty())
	{
		int cur=q.front();
		q.pop();
		if(cur==endd)
		return true;
		
		for(int i=0; i<v[cur].size(); i++)
		{
			int nextpoint(v[cur][i].first);
			int nextweight(v[cur][i].second);
			if(n1<=nextweight && !visited[nextpoint])
			{
				visited[nextpoint]=true;
				q.push(nextpoint);
			}
		}
	}
	return false;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<m; i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		v[a].push_back({b,c});
		v[b].push_back({a,c});
		rightt=max(c,rightt);
	}
	cin>>start>>endd;
	while(leftt<=rightt)
	{
		int mid((leftt+rightt)/2);
		if(possible(mid))
		{
			answer=mid;
			leftt=mid+1;
		}else
		rightt=mid-1;	
	}
	cout<<answer;
	
}
