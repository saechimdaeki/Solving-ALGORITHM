#include<iostream>
#include<algorithm>
#include<tuple>
#include<vector>
#include<queue>
using namespace std;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,-1},{0,1}};
int w,h;
vector<string> grid;
int startx,starty,endx,endy;
bool one;
queue<pair<int,int > > q;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>w>>h;
	grid.resize(h);
	for(int i=0; i<h; i++)
	{
		cin>>grid[i];
		for(int j=0; j<w; j++)
		{
			if(grid[i][j]=='C')
			{
				if(!one)
				{
					one=true;
					startx=i;
					starty=j;
				}else{
					endx=i;
					endy=j;
				}
			}
		}
	}
	vector<vector<int> > v(h, vector<int>(w,-1));
	v[startx][starty]=0;
	q.push({startx,starty});
	while(!q.empty())
	{
		tie(startx,starty)=q.front();
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(startx+quad[i].x),nexty(starty+quad[i].y);
			while(0<=nextx && nextx<h && 0<=nexty && nexty<w)
			{
				if(grid[nextx][nexty]=='*')
				break;
				if(v[nextx][nexty]==-1)
				{
					v[nextx][nexty]=v[startx][starty]+1;
					q.push({nextx,nexty});	
				}
				nextx+=quad[i].x;
				nexty+=quad[i].y;	 // - |  
			}	
		}	
	}
	cout<<v[endx][endy]-1; 
		
}
