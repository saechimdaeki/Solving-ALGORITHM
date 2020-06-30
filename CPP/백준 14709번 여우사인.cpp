#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;

int n;
vector<pair<int, int > > v;
bool solve=true;
int hardcoding;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a,b;
		cin>>a>>b;
		v.push_back({a,b});
	}
	for(int i=0; i<v.size(); i++)
	{
		if(v[i].first==1 &&(v[i].second==4 || v[i].second==3))
		hardcoding++;
		else if(v[i].first==3 &&(v[i].second==4 || v[i].second==1))
		hardcoding++;
		else if(v[i].first==4 &&(v[i].second==3 || v[i].second==1))
		hardcoding++;
		else
		solve=false;
	}
	if(solve && hardcoding>=3)
	cout<<"Wa-pa-pa-pa-pa-pa-pow!";
	else
		cout<<"Woof-meow-tweet-squeek";
	}
	


