#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<pair<int, int> > v;
int grade[51];
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(51);
	for(int i=0; i<n; i++)
	{
		cin>>v[i].first>>v[i].second;
	}
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<n; j++)
		{
			if(v[i].first>v[j].first && v[i].second>v[j].second)
			grade[j]+=1;
		}
	}
	for(int i=0; i<n; i++)
	cout<<grade[i]+1<<" ";
	
}
