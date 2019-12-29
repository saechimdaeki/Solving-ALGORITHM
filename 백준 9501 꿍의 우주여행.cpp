#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;
int t,n,d,cnt;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>t;
	for(int i=0; i<t; i++)
	{
		cin>>n>>d;
		cnt=0;
		int v,f,c;
		for(int j=0; j<n; j++)
		{
			cin>>v>>f>>c;
			if(v*f/c >=d)
			cnt++;
		}
		cout<<cnt<<endl;
	}
}
