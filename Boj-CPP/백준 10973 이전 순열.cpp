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
	v.resize(n);
	for(int i=0; i<n; i++)
	{
		cin>>v[i];
	}
	if(prev_permutation(v.begin(),v.end())==true)
	{
		for(int i=0; i<n; i++)
		cout<<v[i]<<" ";
	}
	else
	cout<<"-1";
}
