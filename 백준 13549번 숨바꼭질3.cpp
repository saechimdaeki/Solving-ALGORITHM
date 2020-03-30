#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<tuple> 
using namespace std;
int n,k,subin_which;
bool visited[100001];
int timer[100001];
queue<int> zerosecond;
queue<int> plusonesecond;
void bfs(int subin, int brother)
{
	zerosecond.push(subin);
	visited[subin]=true;
	timer[subin]=0;
	while(!zerosecond.empty())
	{
		int cur(zerosecond.front());
		zerosecond.pop();
		if(cur*2<100001 && visited[cur*2]==false)
		{
			zerosecond.push(cur*2);
			visited[cur*2]=true;
			timer[cur*2]=timer[cur];
		}
		if(cur-1>=0 && visited[cur-1]==false)
		{
			plusonesecond.push(cur-1);
			visited[cur-1]=true;
			timer[cur-1]=timer[cur]+1;
		}
		if(cur+1<100001 && visited[cur+1]==false)
		{
			plusonesecond.push(cur+1);
			visited[cur+1]=true;
			timer[cur+1]=timer[cur]+1;
		}
		/* 백준센세인강참고 ↓  */
	if(zerosecond.empty())
	{
		zerosecond=plusonesecond;
		plusonesecond=queue<int>();
	}
	}
	
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	bfs(n,k);
	cout<<timer[k];
}
