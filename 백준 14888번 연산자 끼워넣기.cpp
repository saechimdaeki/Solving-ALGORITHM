#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#define endl '\n'
using namespace std;
vector<int> v;
int n,ps,ms,mul,divi;
int minnum=987654321,maxnum=-987654321;
queue<pair<pair<int, int> , pair<pair<int, int>,pair<int, int> > > > q; 

void bfs()
{
	q.push(make_pair(make_pair(v[0],1),make_pair(make_pair(ps,ms),make_pair(mul,divi))));
	z:
	while(!q.empty())
	{
		
		int now(q.front().first.first);
		int count123(q.front().first.second);
		int ps=q.front().second.first.first;
		int ms=q.front().second.first.second;
		int mul=q.front().second.second.first;
		int divi=q.front().second.second.second;
		q.pop();
		if(count123==n)
		{
			maxnum=max(maxnum,now);
			minnum=min(minnum,now);
			goto z;
		}
		if(ps-1>=0)
			q.push(make_pair(make_pair(now+v[count123],count123+1),make_pair(make_pair(ps-1,ms),make_pair(mul,divi))));
		if(ms-1>=0)
			q.push(make_pair(make_pair(now-v[count123],count123+1),make_pair(make_pair(ps,ms-1),make_pair(mul,divi))));
		if(mul-1>=0)
			q.push(make_pair(make_pair(now*v[count123],count123+1),make_pair(make_pair(ps,ms),make_pair(mul-1,divi))));
		if(divi-1>=0)
			q.push(make_pair(make_pair(now/v[count123],count123+1),make_pair(make_pair(ps,ms),make_pair(mul,divi-1))));		
	}
	
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	cin>>ps>>ms>>mul>>divi;
	bfs();
	cout<<maxnum<<endl;
	cout<<minnum;
	
}
