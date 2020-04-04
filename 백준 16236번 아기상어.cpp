#include<iostream>
#include<algorithm>
#include<tuple>
#include<queue>
#include<vector>
using namespace std;
int n;
//튜플짱 
// 상어x 상어 y   상어사이즈 상어경험치 
int sharkx,sharky,sharksize,sharkexp;
int momcall; //끝나는시간 
typedef struct{
	int x, y;
}dir;
dir quad[4]={{-1,0},{1,0},{0,1},{0,-1}};
tuple<int, int , int> bfs(vector<vector<int> > &v, int x, int y ,int size)
{
	int bts=v.size();
	vector<tuple<int,int,int> > ans;
	queue<pair<int, int > > q;
	vector<vector<int> > d(bts,vector<int>(bts,-1));
	q.push({x,y});
	d[x][y]=0;
	while(!q.empty())
	{
		tie(x,y)=q.front();
		q.pop();
		for(int i=0; i<4; i++)
		{
			int nextx(x+quad[i].x),nexty(y+quad[i].y);
			if(0<=nextx && nextx<n && 0<=nexty &&nexty<n &&d[nextx][nexty]==-1)
			{
				bool going(false),eating(false);
				if(v[nextx][nexty]==0)
				going=true;
				else if(v[nextx][nexty]<size)
				{
					going=true;
					eating=true;
				}
				else if(v[nextx][nexty]==size)
				going=true;
				if(going)
				{
					q.push({nextx,nexty});
					d[nextx][nexty]=d[x][y]+1;
					if(eating)
					ans.push_back(make_tuple(d[nextx][nexty],nextx,nexty));
				}
			}
		}
	}
	if(ans.empty())
	return make_tuple(-1,-1,-1);
	sort(ans.begin(),ans.end());
	return ans[0];
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	vector<vector<int> > v(n,vector<int>(n,0));
	sharksize=2;
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			cin>>v[i][j];
			if(v[i][j]==9)
			{
				tie(sharkx,sharky)=make_pair(i,j);
				v[i][j]=0;
			}	
		}	
	}
	while(1)
	{
		int nextx,nexty,dist;
		tie(dist,nextx,nexty)=bfs(v,sharkx,sharky,sharksize);
		if(dist==-1)
		break;
		v[nextx][nexty]=0;
		momcall+=dist;
		sharkexp++;
		if(sharksize==sharkexp)
		{
			sharksize++;
			sharkexp=0;	
		}
		tie(sharkx,sharky)=make_pair(nextx,nexty);	
	} 
	cout<<momcall;
	 
}
