#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#define endl '\n'
using namespace std;
int grid[26][26];
int grouped[26][26];
int n,cnt;
string s;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
int answer[25*25];
void bfs(int x, int y , int cnt)
{
	queue<pair<int, int> > q;
	q.push({x,y});
	grouped[x][y]=cnt;	
	while(!q.empty())
	{
		x=q.front().first;
		y=q.front().second;
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx=quad[i].x+x;
			int nexty=quad[i].y+y;
			if(0<=nextx && nextx<n && 0<=nexty && nexty<n)
			{
				if(grid[nextx][nexty]==1 &&grouped[nextx][nexty]==0 )
				{
					q.push({nextx,nexty});
					grouped[nextx][nexty]=cnt;
				}
			}
		}
	}
} 

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		cin>>s;
		for(int j=0; j<n; j++)
		grid[i][j]=s[j]-'0';	
	}
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(grid[i][j]&& grouped[i][j]==0)
			bfs(i,j,++cnt);
		}
	}
	cout<<cnt<<endl;
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
		answer[grouped[i][j]]++;
		
	sort(answer+1,answer+cnt+1);
	for(int i=1; i<=cnt; i++)
	cout<<answer[i]<<endl;	
		
}
