#include<iostream>
#include<algorithm>
#include<queue>
using namespace std;
int n,m;
typedef struct{
	int y,x;
}dir;

dir quad[4]={{1,0},{-1,0},{0,-1},{0,1}};
int tomato[1001][1001];
//int visited[1001][1001];

queue<pair <int, int> > q;
int not_ripe;

int allgrowcheck()
{
	int a(0);
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(tomato[i][j]==1)
			a++;
		}
	}
	if((m*n-not_ripe)==a)
	return 1;
	else
	return 0;
}

int bfs()
{
	int day=0;
	if(q.size()==0)
	return -1;
	
	while(!q.empty())
	{
		int size=q.size();
		for(int i=0; i<size; i++)
		{
			int y=q.front().first;
			int x=q.front().second;
			q.pop();
			
			for(int j=0; j<4; j++)
			{
				int dy=x+quad[j].y;
				int dx=y+quad[j].x;
				if(dx>=0 && dx <n && dy>=0 &&dy<m )
				{
					if(tomato[dx][dy]==0)
					{
						tomato[dx][dy]=1;
						q.push(make_pair(dx,dy));
					}
				}
			}
		}
		day++;
	}
	if(allgrowcheck()==1)
		return day-1;
	else
	return -1;
}



int main()
{
	
	cin>>m>>n;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			cin>>tomato[i][j];
			
			if(tomato[i][j]==1)
			{
				q.push(make_pair(i,j));
			}
			else if(tomato[i][j]==-1)
			{
				not_ripe++;
			}
		}
	}
	if((m*n-not_ripe)==q.size())
	cout<<"0"<<endl;
	else
	cout<<bfs()<<endl;
}
