#include<iostream>
#include<algorithm>
#include<tuple>
#include<queue>
#include<vector>
#include<cstring>
using namespace std;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
int n;
vector<string> v;
bool blind;
bool visited[101][101];
bool going(bool blind, char from , char to)
{
	if(from==to)
	return true;
	if(blind)
	{
		if(from=='R' &&to=='G')
		return true;
		if(from=='G' && to =='R')
		return true;
	}
	return false;
}
int bfs(bool blind_)
{
	int output(0);
	
	memset(visited,false,sizeof(visited));
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(!visited[i][j])
			{
				output++;
				queue<pair<int,int> > q;
				q.push({i,j});
				visited[i][j]=true;
				while(!q.empty())
				{
					int x,y;
					tie(x,y)=q.front();
					q.pop();
					for(int i=0; i<4; i++)
					{
						int nextx(x+quad[i].x),nexty(y+quad[i].y);
						if(0<=nextx&&nextx<n && 0<=nexty && nexty<n)
						{
							if(visited[nextx][nexty])
							continue;
							if(going(blind_,v[x][y],v[nextx][nexty]))
							{
								q.push({nextx,nexty});
								visited[nextx][nexty]=true;
							}
						}
					}
				}
			}
		}
	}
	return output;
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0;i<n;i++)
	cin>>v[i];
	//적롱색맹인사람 true 아닌사람 false 
	cout<<bfs(false)<<' '<<bfs(true);
}
