#include<iostream>
#include<vector>
using namespace std;
vector<int> v;
int arr[1001][1001];
int n,cmp;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	for(int i=0; i<n; i++)
		for(int j=0; j<n; j++)
			cin>>arr[i][j];
	for(int i=0; i<n; i++)
	{
		cmp=0;
		for(int j=0; j<n; j++)
		{
			if(i==j) 
			continue;
			cmp=arr[i][j]|cmp;				
		}
		v.push_back(cmp);
	}
	
	for(auto i:v)
	cout<<i<<' ';
	
}
