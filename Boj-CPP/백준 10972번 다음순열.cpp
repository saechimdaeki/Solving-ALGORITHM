#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
vector<int> v;
int n;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		v.push_back(a);
	}
	if(next_permutation(v.begin(),v.end()))
	{
		for(auto i:v)
		cout<<i<<' ';
	}else
	cout<<-1;
	
}
