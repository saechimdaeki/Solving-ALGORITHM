#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#define endl '\n'
using namespace std;
int grid[1001][1001];
int state[1001][1001][2]; // 1 or  0   /*  질문검색 및 원룸담배 info.  */
//int crashwall; //벽부수기 
//int cnt=1;//최단거리용 
string s;
typedef struct{
	int x,y;
}dir;

dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};

int n,m; 
int bfs(int x1,int y1)
{
	queue<pair<pair<int, int>,int > > q;
	q.push(make_pair(make_pair(x1,y1),1));
	state[0][0][1]=1;

	while(!q.empty())
	{
		int curx(q.front().first.first);
		int cury(q.front().first.second);
		int wall(q.front().second);
		if(curx==n-1 && cury==m-1)
		return state[curx][cury][wall];
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(curx+quad[i].x);
			int nexty(cury+quad[i].y);
			if(nextx<0 || nextx>=n || nexty<0 || nexty>=m)
			continue;
			if (grid[nextx][nexty]==1 && wall==0 )
			continue;
			if (grid[nextx][nexty]==1 && wall ==1 )
			{
				state[nextx][nexty][wall-1]=state[curx][cury][wall]+1;
				q.push(make_pair(make_pair(nextx,nexty),wall-1));
			}else if (grid[nextx][nexty]==0 && state[nextx][nexty][wall]==0)
			{
				state[nextx][nexty][wall]=state[curx][cury][wall]+1;
				q.push(make_pair(make_pair(nextx,nexty),wall));
			}
				
		}	
	}
	return -1;
		
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		cin>>s;
		for(int j=0; j<m; j++)
		{
			grid[i][j]=s[j]-'0';
		}
	}
	cout<<bfs(0,0);
}

