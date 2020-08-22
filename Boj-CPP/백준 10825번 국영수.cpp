#include<iostream>
#include<algorithm>
#include<vector>
#include<functional>
using namespace std;

int n;
//vector<pair <pair<string, int>,pair<int , int > >> v; 이렇게시도햇엇으나 계속해서 안되서..벡터제외 
pair <pair<string, int>,pair<int , int > > v[100000];

bool greatttt(pair <pair <string, int> , pair<int ,int > > p1, pair<pair<string,int>,pair<int , int> > p2)
{
	if(p1.first.second>p2.first.second)
	return true;
	else if(p1.first.second==p2.first.second)
	{
		if(p1.second.first<p2.second.first)
		return true;
		else if(p1.second.first==p2.second.first)
		{
			if(p1.first.first<p2.first.first)
			return true;
			else if(p1.second.second==p2.second.second)
			 if(p1.first.first<p2.first.first)
					return true;
		}
	}
	return false;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	
	
	for(int i=0; i<n; i++)
	cin>>v[i].first.first>>v[i].first.second>>v[i].second.first>>v[i].second.second;
	
	sort(v,v+n,greatttt);
	for(int i=0; i<n; i++)
	cout<<v[i].first.first<<"\n";
}


 
