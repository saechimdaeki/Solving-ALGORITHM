#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int n,count123;
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n;
	v.resize(n);
	for(int i=0; i<n; i++)
	cin>>v[i];
	int compare(v[n-1]);//내림차순으로 진행예정 
	for(int i=n-2; i>=0; i--)
	{
		while(v[i]>=compare)
		{
			v[i]--;
			count123++;
		}
		compare=v[i];
	}
	cout<<count123;
}
