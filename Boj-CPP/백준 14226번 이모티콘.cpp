#include<iostream>
#include<algorithm>
#include<cstring>
#include<queue>
#include<tuple>
using namespace std;
int s,cnt,a,b;
int grid[1001][1001];
queue<pair<int, int> > q;
int answer(-2e9+1);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s;
	memset(grid,-1,sizeof(grid));
	q.push({1,0});
	while(!q.empty())
	{
		/*
		int a(q.front().first);
		int b(q.front().second);
		*/
		tie(a,b)=q.front(); //Æ©ÇÃ ÁÁ³× 
		q.pop();
		if(grid[a][a]==-1)
		{
			grid[a][a]=grid[a][b]+1;
			q.push({a,a});
		}
		if(a+b<=s && grid[a+b][b]==-1)
		{
			grid[a+b][b]=grid[a][b]+1;
			q.push({a+b,b});
		}
		if(a-1>=0 &&grid[a-1][b]==-1)
		{
			grid[a-1][b]=grid[a][b]+1;
			q.push({a-1,b});
			}	
	}
	for(int i=0; i<=s; i++)
	{
		if(grid[s][i]!=-1)
			if(answer==-2e9+1 ||answer>grid[s][i])
				answer=grid[s][i];
	}	
	cout<<answer+1;	
} 
