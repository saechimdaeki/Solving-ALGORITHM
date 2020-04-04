#include<iostream>
#include<algorithm>
#include<tuple>
#include<queue>
#include<set>
#define maxx 1000000000
using namespace std;
long long s,t;
set<long long> visited;
queue<pair<long long, string> > q;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>s>>t;
	q.push({s,""});
	visited.insert(s);
	while(!q.empty())
	{
		long long cur;
		string curs;
		tie(cur,curs)=q.front();
		q.pop();
		if(cur==t)
		{
			if(curs.length()==0)
			curs="0";
			cout<<curs;
			return 0;
		}
		// * + - / 순서 주의 ;;;; 
		if(0<=cur*cur&&cur*cur<=maxx && visited.count(cur*cur)==0)
		{
			q.push({cur*cur,curs+"*"});
			visited.insert(cur*cur);
		}
		if(0<=cur+cur && cur+cur<=maxx &&visited.count(cur+cur)==0)
		{
			q.push({cur+cur,curs+"+"});
			visited.insert(cur+cur);
		}
		if(0<=cur-cur && cur-cur<=maxx && visited.count(cur-cur)==0)
		{
			q.push({cur-cur,curs+"-"});
			visited.insert(cur-cur);
		}
		if(0!=cur && 0<=cur/cur && cur/cur <=maxx && visited.count(cur/cur)==0)
		{
			q.push({cur/cur,curs+"/"});
			visited.insert(cur/cur);
		}
		
	}
	cout<<-1;
}
