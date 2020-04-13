#include<iostream>
#include<vector>
#include<algorithm>
#include<set>
using namespace std;
bool visited[25601];
int grid[5][5];
set<int> ans;
typedef struct{
	int x,y;
}dir;
dir quad[4]={{0,1},{0,-1},{1,0},{-1,0}};
void brute(int x, int y, int num, int len)
{
	if(len==6)
	{
		ans.insert(num);
		return;
	}
	for(int i=0; i<4; i++)
	{
		int nextx=x+quad[i].x;
		int nexty=y+quad[i].y;
		if(0<=nextx && nextx<5 && 0<=nexty &&nexty<5)
			brute(nextx,nexty,num*10+grid[nextx][nexty],len+1);
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	for(int i=0; i<5; i++)
		for(int j=0;j<5; j++)
			cin>>grid[i][j];		
	for(int i=0; i<5; i++)
		for(int j=0; j<5; j++)
			brute(i,j,grid[i][j],1);
		
	cout<<ans.size();	
}
