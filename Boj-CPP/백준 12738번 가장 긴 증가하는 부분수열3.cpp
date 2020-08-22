#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int a;
		cin>>a;
		auto iterator=lower_bound(v.begin(),v.end(),a);
		if(iterator==v.end())
		v.push_back(a);
		else
		*iterator=a;
	}
	cout<<v.size();
}
