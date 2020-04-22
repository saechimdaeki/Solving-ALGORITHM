#include<iostream>
#include<algorithm>
#define endl '\n'
using namespace std;
int grid[129][129];
int n;
int cnt,bluecnt;

void solve(int startx, int starty , int n)
{
	int color=grid[startx][starty];
	for(int i=startx; i<startx+n; i++)
	{
		for(int j=starty; j<starty+n; j++)
		{
			if(grid[i][j]!=color)
			{
				solve(startx,starty,n/2);
				solve(startx+n/2,starty,n/2);
				solve(startx,starty+n/2,n/2);
				solve(startx+n/2,starty+n/2,n/2);
				return;
			}
		}
	}
	if(color==1)
	bluecnt++;
	else
	cnt++;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
			cin>>grid[i][j];
	solve(0,0,n);
	cout<<cnt<<endl;
	cout<<bluecnt;
}
