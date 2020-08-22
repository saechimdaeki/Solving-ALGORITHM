#include<iostream>
#include<algorithm>
#include<queue>
#include<tuple>
#define endl '\n'
using namespace std;
struct dir{
	int x, y;
};
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
string grid[500];
bool visited[500][500]; 
int r,c;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>r>>c;
	for(int i=0; i<r; i++)
		cin>>grid[i];
	bool sheepsafe=true;
	for(int i=0; i<r; i++)
	{
		for(int j=0; j<c; j++)
		{
			if(grid[i][j]=='S')
			{
				for(int k=0; k<4; k++)
				{
					int nextx=i+quad[k].x;
					int nexty=j+quad[k].y;
					if(0<=nextx && nextx<r && 0<=nexty && nexty<c)
					{
						if(grid[nextx][nexty]=='W')
							sheepsafe=false;
					}
				}	
			}	
		}	
	}
	if(!sheepsafe)
	cout<<0;
	else
	{
		cout<<1<<endl;
		for(int i=0; i<r; i++)
		{
			for(int j=0; j<c; j++)
			{
				if(grid[i][j]=='.')
				cout<<'D';
				else
				cout<<grid[i][j];	
			}
			cout<<endl;	
		}	
	}	
}
