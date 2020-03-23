#include<iostream>
#include<algorithm>
#include<vector>
#define endl '\n'
using namespace std;
vector<int> v;
int n,m;
bool check[10];

void recur(int idx,int start, int n1, int m1)
{
	if(idx==m1)
	{
		for(int i=0; i<m1; i++)
		cout<<v[i]<<' ';
		cout<<endl;
		return;
	}
	for(int i=start; i<=n; i++)
	{
		v[idx]=i;
		recur(idx+1,i,n,m);
	}
}


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin>>n>>m;
	v.resize(n);
	recur(0,1,n,m);		
}
