#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v,v2;
int n,m;
bool check[10];

void recur(int idx,int start, int n1, int m1)
{
	if(idx==m1)
	{
		for(int i=0; i<m1; i++)
		cout<<v2[v[i]]<<' ';
		cout<<endl;
		return;
	}
	for(int i=start; i<n; i++)
	{
		check[i]=true;
		v[idx]=i;
		recur(idx+1,i,n,m);
		check[i]=false;
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);v2.resize(n);
	for(int i=0; i<n; i++)
	cin>>v2[i];
	sort(v2.begin(),v2.end());
	recur(0,0,n,m);		
}
