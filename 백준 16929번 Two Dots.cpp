#include<iostream>
#include<cstring>
using namespace std;
typedef struct{
	int x,y;
}dir;
char arr[55][55];
bool check[55][55];
int distan[55][55];
int n,m;
dir quad[4]={{0,1},{0,-1},{1,0},{-1,0}};
bool dfs(int x,int y, int cnt, char color)
{
	if(check[x][y])
	{
		if(cnt-distan[x][y]>=4)
		return true;
		else
		return false;
	}
	check[x][y]=true;
	distan[x][y]=cnt;
	for(int i=0; i<4; i++)
	{
		int nextx(x+quad[i].x);
		int nexty(y+quad[i].y);
		if(0<=nextx && nextx<n && 0<=nexty && nexty<m)
		{
			if(arr[nextx][nexty]==color)
			{
				if(dfs(nextx,nexty,cnt+1,color))
				return true;
			}
		}
	}
	return false;
	
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	cin>>arr[i];
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			if(check[i][j])
			continue;
			memset(distan,0,sizeof(distan));
			bool isok(dfs(i,j,1,arr[i][j]));
			if(isok)
			{
				cout<<"Yes";
				return 0;
			}
		}
	}
	cout<<"No";
}

