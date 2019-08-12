#include<iostream>
#include<vector>
#include<algorithm>
#define endl '\n'
using namespace std;
int a,n,sum;
int sumarray[300001];
vector<int> v;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>a>>n;
	v.resize(a);
	for(int i=0; i<a; i++)
		cin>>v[i];
	sort(v.begin(),v.end());
	for(int i=0; i<a; i++)
	{
		sum+=v[i];
		sumarray[i]=sum;
	}
	for(int i=0; i<n; i++)
	{
		int l,r;
		cin>>l>>r;
		cout<<sumarray[r-1]-sumarray[l-2]<<endl;
	}

}
