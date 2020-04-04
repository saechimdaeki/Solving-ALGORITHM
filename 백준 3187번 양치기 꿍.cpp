#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>
#include<tuple>
using namespace std;
int r,c;
vector<string> v;
bool visited[250][250];
typedef struct{
	int x,y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};

pair<int,int> bfs(int x,int y)
{
	queue<pair<int, int> > q;
	q.push({x,y});
	
	visited[x][y]=true;
	int sheep(0),wolf(0);
	while(!q.empty())
	{
		
		tie(x,y)=q.front();
		q.pop();
		
		if(v[x][y]=='v')
		wolf++;
		else if(v[x][y]=='k')
		sheep++;
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y);
			if(0<=nextx && nextx<r &&0<=nexty &&nexty<c)
			{
				if(!visited[nextx][nexty] &&v[nextx][nexty]!='#' )
				{
					q.push({nextx,nexty});
					visited[nextx][nexty]=true;
				}
			}
		}
	}
	if(sheep>wolf)
	return {sheep,0};
	else
	return {0,wolf};
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>r>>c;
	v.resize(r);
	for(int i=0; i<r; i++)
		cin>>v[i];
		//first¾ç second´Á´ë 
	pair<int, int> answer={0,0};
	for(int i=0; i<r; i++)
	{
		for(int j=0; j<c; j++)
		{
			if(v[i][j]!='#' && !visited[i][j])
			{
				pair<int, int> tmp=bfs(i,j);
				answer.first+=tmp.first;
				answer.second+=tmp.second;	
			}	
		}	
	}
	cout<<answer.first<<' '<<answer.second;	
}
