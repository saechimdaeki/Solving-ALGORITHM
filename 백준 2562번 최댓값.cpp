#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<pair <int , int>> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.resize(9);
	for(int i=0; i<9; i++)
	{
		cin>>v[i].first;
		v[i].second=i+1;
	}
	sort(v.begin(),v.end());
	cout<<v[8].first<<"\n";
	cout<<v[8].second;
}
