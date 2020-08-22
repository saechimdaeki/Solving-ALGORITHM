#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main()
{
	vector<int> bts;
	int n;
	cin>>n;
	for(int i=0; i<n; i++)
	{
		int abc;
		cin>>abc;
		bts.push_back(abc);
	}
	sort(bts.begin(),bts.end());
	cout<<bts[0]*bts[n-1];
}
