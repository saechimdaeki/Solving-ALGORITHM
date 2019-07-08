#include<iostream>
#include<algorithm>
#include<queue>
#include<functional>
#include<vector>
using namespace std;
int n,m,save;
int matrix[8][8]; int state[8][8];
//class style{
//	public:
//		int x,y;
//};
//style st[4]={{0,1},{0,-1},{1,0},{-1,0}};
int curx[4]={0,0,1,-1};
int cury[4]={1,-1,0,0};
//vector<pair<int , int > > v;
queue<pair<int,int> > q;
void virus()
{
	int aftervirus[8][8];
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		aftervirus[i][j]=state[i][j];
	}
	
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(aftervirus[i][j]==2)
			q.push(make_pair(i,j));//바이러스면 큐에넣자 여기까지는 쉽고  
		}
	}
	while(!q.empty())
	{
		int x(q.front().first);
		int y(q.front().second);
		q.pop();
		for(int i=0; i<4; i++)
		{
			int quadx(x+curx[i]);
			int quady(y+cury[i]);
			if(0<=quadx && quadx<n && 0<= quady && quady<m)
			{
				if(aftervirus[quadx][quady]==0)
				{
					aftervirus[quadx][quady]=2;
					q.push(make_pair(quadx,quady));
				}
			}
		}
	}
	int count123(0);  
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		if(aftervirus[i][j]==0)
		count123++;
	}
	save=max(save,count123);
}
void walldfs(int num)
{
	if(num==3)
	{
		virus();
		return;
	}
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(state[i][j]==0)
			{
				state[i][j]=1;
				walldfs(num+1);
				state[i][j]=0;			
			}			
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		cin>>matrix[i][j];
	}
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(matrix[i][j]==0)
			{
				for(int k=0; k<n; k++)
				{
					for(int t=0; t<m; t++)
						state[k][t]=matrix[k][t];
				}		
				state[i][j]=1;
				walldfs(1);
				state[i][j]=0;
			}
		}
	}
	cout<<save;
}
