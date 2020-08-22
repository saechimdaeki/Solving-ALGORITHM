#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<tuple>
using namespace std;
int n,k,timer,minsecond,subin_which,bangbup;
bool visited[100001];
void bfs(int subin, int brother)
{
	queue<pair<int, int> > q;
	q.push({subin,0});
	visited[subin]=true;
	while(!q.empty())
	{
		tie(subin_which, timer)=q.front();
		q.pop();
		visited[subin_which]=true;
		if(minsecond && minsecond==timer && subin_which==brother)
			bangbup++;
		if(minsecond==0 && subin_which==brother )
			{
				minsecond=timer;
				bangbup++;
			}	
		
		if(subin_which*2<100001 && !visited[subin_which*2])
		{
			q.push({subin_which*2,timer+1});
		}
		if(subin_which+1<100001 &&!visited[subin_which+1])
		{
			q.push({subin_which+1,timer+1});
		}
		if(subin_which-1>=0 && !visited[subin_which-1])
		{
			q.push({subin_which-1,timer+1});
		}
	}
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>k;
	bfs(n,k);
	cout<<minsecond<<endl;
	cout<<bangbup;
}
