#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;

int n,cnt,answer;
vector<pair<int, int> > v;
bool cmp(pair<int, int > v1, pair<int, int> v2)
{
	return v1.second>v2.second;
}
priority_queue<int> q;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i].first>>v[i].second;
	sort(v.begin(),v.end(),cmp);
	for(int i=10000; i>=1; i--)
	{
		while(cnt<n && v[cnt].second==i)
		{
			q.push(v[cnt].first);
			cnt++;
		}
		if(!q.empty())
		{
			answer+=q.top();
			q.pop();
		}	
	}
	cout<<answer;	
}
