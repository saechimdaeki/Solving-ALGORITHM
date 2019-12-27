#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	v.resize(3);
	for(int i=0; i<3; i++)
	cin>>v[i];
	sort(v.begin(),v.end());
	for(int i=0; i<3; i++)
	cout<<v[i]<<' ';
}
