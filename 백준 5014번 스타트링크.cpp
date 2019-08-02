#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
using namespace std;
int grid[1000000];
//bool visited[1000001];
int f,s,g,u,d;
queue<int> q;
int bfs(int s1)
{
	q.push(s1);
	grid[s1]=1;
	//visited[s]=true;
	while(!q.empty())
	{
		int now(q.front());
		q.pop();
		if(now==g)
		return grid[now];
			if(1<=now+u&&now+u<=f &&grid[now+u]==0)
			{
				grid[now+u]=grid[now]+1;
				q.push(now+u);
			}
			if(1<=now-d&&now-d<=f &&grid[now-d]==0)
			{
				grid[now-d]=grid[now]+1;
				q.push(now-d);
			}
	}
	return 12345;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>f>>s>>g>>u>>d;
	int answer(bfs(s));
	if(answer==12345)
	cout<<"use the stairs";
	else
	cout<<answer-1;
	
}

