#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int r,c;
typedef struct{
	int x, y;
}dir;
dir quad[4]={{1,0},{-1,0},{0,1},{0,-1}};
vector<string >grid;
vector<bool> checklist;
int solve(vector<string> &s, vector<bool> &c, int x, int y)
{
	int answer(0);
	for(int i=0; i<4; i++)
	{
		int nextx(x+quad[i].x),nexty(y+quad[i].y);
		if(nextx>=0 && nextx<s.size() && nexty>=0 && nexty<s[0].size())
		{
			if(!c[(int)s[nextx][nexty]-65])
			{
				c[(int)s[nextx][nexty]-65]=true;
				int nextstep=solve(s,c,nextx,nexty);
				answer=max(answer,nextstep);
				c[(int)s[nextx][nexty]-65]=false;
			}
		}
	}
	return answer+1;
	
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin>>r>>c;
	grid.resize(r);
	for(int i=0; i<r; i++)
	cin>>grid[i];
	checklist.resize(26);
	checklist[(int)grid[0][0]-65]=true;

	cout<<solve(grid,checklist,0,0);
	
}
