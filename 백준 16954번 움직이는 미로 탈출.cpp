#include<iostream>
#include<queue>
#include<algorithm>
#include<string>
#include<tuple>
using namespace std;
bool possible;
vector<string> v;
typedef struct{
	int x,y;
}dir;
dir quad[9]={{-1,-1},{-1,1},{-1,0},{1,0},{0,0},{0,1},{0,-1},{1,1},{1,-1}};
bool visited[8][8][9]; 
void bfs(int x,int y, int z)
{
	queue<tuple<int, int , int > > q;
	q.push(make_tuple(x,y,z));
	visited[x][y][z]=true;
	while(!q.empty())
	{
		tie(x,y,z)=q.front();
		q.pop();
		if(x==0 && y==7)
		{
			possible=true;
			return;
		}
		for(int i=0; i<9; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y),nextz(min(z+1,8));
			if(0<=nextx &&nextx<8 && nexty>=0 && nexty<8)
			{
				if(nextx-z>=0 &&v[nextx-z][nexty]=='#') //next point ==wall
				continue;
				if(nextx-z-1>=0 && v[nextx-z-1][nexty]=='#')// next point after 1second ==wall
				continue;
				if(!visited[nextx][nexty][nextz])
				{
					visited[nextx][nexty][nextz]=true;
					q.push(make_tuple(nextx,nexty,nextz));
				}
			}
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.resize(8);
	for(int i=0; i<8; i++)
		cin>>v[i];
	bfs(7,0,0);
	if(possible)
	cout<<1;
	else
	cout<<0;
}
