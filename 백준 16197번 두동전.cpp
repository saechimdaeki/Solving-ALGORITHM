#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int coin1x(-1),coin1y(-1), coin2x(-1),coin2y(-1);

typedef struct{
	int x,y;
}dir;
int n,m;
dir quad[4]={{0,1},{0,-1},{1,0},{-1,0}};
string s[20];
bool coin1fall,coin2fall; 
int solve(int cnt,int x1,int y1,int x2,int y2)
{
	if(cnt>10)
		return -1;
	coin1fall=coin2fall=false;
	if(x1<0 ||x1>=n ||y1<0 || y1>=m)
	coin1fall=true;
	if(x2<0 ||x2>=n ||y2<0 ||y2>=m)
	coin2fall=true;
	if(coin1fall && coin2fall)
	return -1;
	if(coin1fall || coin2fall)
	return cnt;
	int answer=-1;
	for(int i=0; i<4; i++)
	{
		int nextx1(x1+quad[i].x);
		int nexty1(y1+quad[i].y);
		int nextx2(x2+quad[i].x);
		int nexty2(y2+quad[i].y);
		if(0<=nextx1 && nextx1<n && 0<=nexty1 &&nexty1<m &&s[nextx1][nexty1]=='#')
		{
			nextx1=x1;
			nexty1=y1;
		}
		if(0<=nextx2 && nextx2<n && 0<=nexty2 && nexty2<m && s[nextx2][nexty2]=='#')
		{
			nextx2=x2;
			nexty2=y2;
		}
		int tmp(solve(cnt+1,nextx1,nexty1,nextx2,nexty2));
		if(tmp==-1)
		continue;
		if(answer==-1 ||answer>tmp)
		answer=tmp;
	}
	return answer;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	for(int i=0; i<n; i++)
	{
		cin>>s[i];
	for(int j=0; j<m; j++)
	{
		if(s[i][j]=='o')
		{
			if(coin1x==-1)
			{
				coin1x=i;
				coin1y=j;	
			}else{
				coin2x=i;
				coin2y=j;
			}
			s[i][j]='.';	
		}	
	}
	}
	cout<<solve(0,coin1x,coin1y,coin2x,coin2y);
} 
