#include<iostream>
#include<queue>
#include<algorithm>
#include<vector>
#include<tuple>
#include<cstring>
using namespace std;
typedef struct{
	int x,y;
}dir;
dir quad[6]={{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
int n;
int startx,starty,endx,endy;
int grid[201][201];
int answer[201][201];
bool possible;
void bfs(int s_x,int s_y)
{
	queue<pair<int, int> > q;
	q.push({s_x,s_y});
	answer[s_x][s_y]=0;
	while(!q.empty())
	{
		tie(s_x,s_y)=q.front();
		q.pop();
		if(s_x==endx && s_y==endy)
		{
			possible=true;
			return;
		}
		for(int i=0; i<6; i++)
		{
			int nextx(s_x+quad[i].x);
			int nexty(s_y+quad[i].y);
			if(0<=nextx && nextx<n && 0<=nexty && nexty<n)
			{
				if(answer[nextx][nexty]==-1)
				{
					q.push({nextx,nexty});
					answer[nextx][nexty]=answer[s_x][s_y]+1;	
				}
				
			}	
		}
	}
}
/*After solving it, you can see it, but you don't need a posible variable.  */
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	cin>>startx>>starty>>endx>>endy;
	memset(answer,-1,sizeof(answer));
	bfs(startx,starty);
	if(possible)
	cout<<answer[endx][endy];
	else
	cout<<-1;
}
