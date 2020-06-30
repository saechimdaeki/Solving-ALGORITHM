#include<iostream>
#include<queue>
using namespace std;
int f,s,g,u,d;
int dist[1000001];
bool visited[1000001];
void bfs(int start)
{
	queue<int> q;
	q.push(start);
	visited[start]=true;
	while(!q.empty())
	{
		int current=q.front();
		q.pop();
		if(1<=current-d && !visited[current-d])
		{
			q.push(current-d);
			dist[current-d]=dist[current]+1;
			visited[current-d]=true;	
		}
		if(current+u<=f && !visited[current+u])
		{
			q.push(current+u);
			dist[current+u]=dist[current]+1;
			visited[current+u]=true;
		}
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>f>>s>>g>>u>>d;
	bfs(s);
	if(visited[g])
	cout<<dist[g];
	else
	cout<<"use the stairs";
}
