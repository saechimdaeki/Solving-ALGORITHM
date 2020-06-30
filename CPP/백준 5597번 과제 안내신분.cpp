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
	for(int i=0; i<28; i++)
	{
		cin>>n;
		v.push_back(n);
	}
	sort(v.begin(),v.end());
	for(int i=1; i<=30; i++)
	{
		if(binary_search(v.begin(),v.end(),i)==0)
		cout<<i<<"\n";
	}
}
