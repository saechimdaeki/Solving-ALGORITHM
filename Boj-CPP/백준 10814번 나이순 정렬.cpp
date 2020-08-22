#include<iostream>
#include<vector>
#include<functional>
#include<algorithm>

using namespace std;
int n;

vector<pair<int , string > > v;

bool biggerrrr(pair<int , string> v1, pair<int ,string> v2)
{
	if(v1.first<v2.first)
	return true;
	else if(v1.first==v2.first)
	return false;
	return false;
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i].first>>v[i].second;	
	}
	
	stable_sort(v.begin(),v.end(),biggerrrr);
	for(int i=0; i<v.size(); i++)
	{
		cout<<v[i].first<<" "<<v[i].second<<"\n";
	}
	
}
